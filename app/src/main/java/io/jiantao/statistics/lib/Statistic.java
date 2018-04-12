package io.jiantao.statistics.lib;

import android.util.Log;

import io.jiantao.statistics.lib.util.Utils;
import io.jiantao.statistics.sample.EventData;

import static io.jiantao.statistics.lib.StatConfig.PAGE;

/**
 * @author jiantao
 * @date 2018/4/9
 */
public class Statistic {

    public static final String LOG_TAG = Statistic.class.getSimpleName();

    private static volatile Statistic sInstance;

    private String api;

    private IDataCache<IRawData> dataCache;

    private IUploadBehavior uploadBehavior;

    private HttpStack<String> httpStack;

    private TaskManager taskManager;
    private StatConfig config;

    public static Statistic get() {
        if (sInstance == null) {
            synchronized (Statistic.class) {
                if (sInstance == null) {
                    checkAndInitStatistic();
                }
            }
        }
        return sInstance;
    }

    private static void checkAndInitStatistic() {

    }

    Statistic(String api, IDataCache<IRawData> dataCache, HttpStack<String> httpStack, IUploadBehavior uploadBehavior) {
        this.api = api;
        this.dataCache = dataCache;
        this.httpStack = httpStack;
        this.uploadBehavior = uploadBehavior;
        this.taskManager = new TaskManager();
        this.config = new StatConfig(Utils.generateUUID());
    }


    /**
     * 事件统计
     *
     * @param action
     */
    public static void onEvent(String action) {
        if (action == null) {
            Log.w(LOG_TAG, "onEvent note-> action = null");
            return;
        }
        final StatConfig config = get().getConfig();
        if (!action.contains(PAGE)) {
            action = config.getResumePage() + ">" + action;
        }
        EventData data = new EventData();
        data.time = Utils.getCurrentSecondTime();
        data.action = action;
        data.gUuid = config.gUuid;
        data.pvUuid = config.pvUUid;

        get().taskManager.addTask(TaskManager.TASK_TYPE_SAVE_DATA, data);

    }


    public String getApi() {
        return api;
    }

    public IDataCache<IRawData> getDataCache() {
        return dataCache;
    }

    public IUploadBehavior getUploadBehavior() {
        return uploadBehavior;
    }

    public HttpStack<String> getHttpStack() {
        return httpStack;
    }

    StatConfig getConfig() {
        return config;
    }
}
