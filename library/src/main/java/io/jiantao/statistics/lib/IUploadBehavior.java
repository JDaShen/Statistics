package io.jiantao.statistics.lib;

/**
 * 上传行为机制
 *
 * @author jiantao
 * @date 2018/4/4
 */
public interface IUploadBehavior {


    /**
     * 上传间隔时间周期
     *
     * @return
     */
    int calculatePeriod();

}
