package io.jiantao.statistics.lib;

import io.jiantao.statistics.sample.MetaData;

/**
 * 配置类： 存放临时变量
 *
 * @author jiantao
 * @date 2018/4/11
 */
class StatConfig {

    static final CharSequence PAGE = "page";

    final String gUuid;
    MetaData metaData;

    String resumePage;
    long resumeTime;
    String pvUUid;

    String from;

    public StatConfig(String gUuid) {
        this.gUuid = gUuid;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public String getResumePage() {
        return resumePage;
    }

    public void setResumePage(String resumePage) {
        this.resumePage = resumePage;
    }

    public long getResumeTime() {
        return resumeTime;
    }

    public void setResumeTime(long resumeTime) {
        this.resumeTime = resumeTime;
    }

    public String getPvUUid() {
        return pvUUid;
    }

    public void setPvUUid(String pvUUid) {
        this.pvUUid = pvUUid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
