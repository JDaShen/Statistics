package io.jiantao.statistics.lib;

import android.text.TextUtils;

/**
 * builder 创建Statistic对象。
 *
 * @author jiantao
 * @date 2018/4/10
 */
public final class StatBuilder {

    /**
     * upload server api
     */
    private String api;

    private IDataCache<IRawData> dataCache;

    private IUploadBehavior uploadBehavior;

    private HttpStack<String> httpStack;

    public StatBuilder setDataCache(IDataCache<IRawData> dataCache) {
        this.dataCache = dataCache;
        return this;
    }

    public StatBuilder setUploadBehavior(IUploadBehavior uploadBehavior) {
        this.uploadBehavior = uploadBehavior;
        return this;
    }

    public StatBuilder setHttpStack(HttpStack<String> httpStack) {
        this.httpStack = httpStack;
        return this;
    }

    public StatBuilder setServerApi(String api) {
        this.api = api;
        return this;
    }

    public Statistic build() {
        if (TextUtils.isEmpty(api)) {
            throw new RuntimeException(" must set a valid api !!!");
        }
        if (dataCache == null) {
            throw new RuntimeException(" must set a dataCache obj !!!");
        }

        if (httpStack == null) {
            httpStack = new DefaultHttpStackImpl();
        }

        if (uploadBehavior == null) {
            uploadBehavior = new DefaultUploadBehavior();
        }
        return new Statistic(api, this.dataCache, this.httpStack, this.uploadBehavior);
    }
}
