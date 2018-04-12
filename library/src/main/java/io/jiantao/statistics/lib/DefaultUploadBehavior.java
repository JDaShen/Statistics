package io.jiantao.statistics.lib;

/**
 * @author jiantao
 * @date 2018/4/10
 */
public class DefaultUploadBehavior implements IUploadBehavior {

    static final int MAX_PERIOD = 60;
    private int mPeriod = 0;

    /**
     * 上传时间间隔
     * 打开的时候长传第一次
     * 打开后5s的时候上传第二次
     * 第二次上传后的15s后，上传第三次
     * 第三次上传后的25s后，上传第四次
     * 以此类推……
     * 最长的间隔是60s
     *
     * @return
     */
    @Override
    public int calculatePeriod() {
        if (mPeriod <= 0) {
            mPeriod += 5;
        } else if (mPeriod < MAX_PERIOD) {
            mPeriod += 10;
        }
        return mPeriod > MAX_PERIOD ? MAX_PERIOD : mPeriod;
    }

    /**
     * 重置周期
     */
    public void reset() {
        mPeriod = 0;
    }
}
