package io.jiantao.statistics.lib;

/**
 * @author jiantao
 * @date 2018/4/9
 */
public class Statistic {

    private static volatile Statistic sInstance;

    private String api;

    private IDataCache<?, IRawData> dataCache;

    private IUploadBehavior uploadBehavior;

    private HttpStack<?> httpStack;

    private TaskManager taskManager;

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

    Statistic(String api, IDataCache<?> dataCache, HttpStack<?> httpStack, IUploadBehavior uploadBehavior){
        this.api = api;
        this.dataCache = dataCache;
        this.httpStack = httpStack;
        this.uploadBehavior = uploadBehavior;
        this.taskManager = new TaskManager();
    }


    /**
     * 事件统计
     * @param action
     */
    public static void onEvent(String action){

        get().getDataCache().createRawData(IRawData.TYPE_EVENT_DATA, action);

        get().taskManager.addTask(TaskManager.TASK_TYPE_SAVE_DATA, rawData);

    }

    public void

    public String getApi() {
        return api;
    }

    public IDataCache<?, IRawData> getDataCache() {
        return dataCache;
    }

    public IUploadBehavior getUploadBehavior() {
        return uploadBehavior;
    }

    public HttpStack<?> getHttpStack() {
        return httpStack;
    }
}
