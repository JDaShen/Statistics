package io.jiantao.statistics.lib;

import android.support.annotation.IntDef;
import android.util.Log;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.jiantao.statistics.lib.util.RunnablePool;

/**
 * 任务管理器。 处理save、delete、upload等数据操作。
 *
 * @author jiantao
 * @date 2018/4/6
 */
class TaskManager {
    static final String TAG = TaskManager.class.getSimpleName();

    static final int TASK_TYPE_SAVE_DATA = 1;
    static final int TASK_TYPE_DELETE_DATA = 2;
    static final int TASK_TYPE_UPLOAD_DATA = 3;


    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    // We want at least 2 threads and at most 4 threads in the core pool,
    // preferring to have 1 less than the CPU count to avoid saturating
    // the CPU with background work
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_SECONDS = 30;

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "Statistics workThread #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new PriorityBlockingQueue<>();

    /**
     * An {@link Executor} that can be used to execute tasks in parallel.
     */
    static final Executor THREAD_POOL_EXECUTOR;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    @IntDef({TASK_TYPE_SAVE_DATA, TASK_TYPE_DELETE_DATA, TASK_TYPE_UPLOAD_DATA})
    @interface TaskType {
    }

    private RunnableExecutor runnableExecutor;

    public TaskManager() {
        runnableExecutor = new RunnableExecutor();
    }

    void addTask(@TaskType int taskType, Object... params) {
        Runnable runnable = RunnablePool.obtain(runnableExecutor, taskType, params);

        THREAD_POOL_EXECUTOR.execute(runnable);
    }

    static class RunnableExecutor implements RunnablePool.IRunnbleExecutor {
        @Override
        public void execute(int what, Object... params) {
            if (params == null || params.length <= 0) {
                Log.e(TAG, "RunnableExecutor params is invalid !!!");
                return;
            }
            Statistic stat = Statistic.get();
            IDataCache<IRawData> dataCache = stat.getDataCache();
            switch (what) {
                case TASK_TYPE_SAVE_DATA:
                    // TODO: 2018/4/10 confirm data type
                    dataCache.cache(((IRawData) params[0]));
                    break;
                case TASK_TYPE_DELETE_DATA:
                    dataCache.delete(((int) params[0]));
                    break;
                case TASK_TYPE_UPLOAD_DATA:
                    final List<?> objects = dataCache.get(((int) params[0]));
                    // TODO: 2018/4/12 need  dataConvert
                    final String data = "";
                    Statistic.get().getHttpStack().syncData(data);
                    break;
                default:
                    break;
            }
        }
    }
}
