package io.jiantao.statistics.lib.imp;

import com.google.gson.annotations.SerializedName;

import io.jiantao.statistics.lib.IRawData;

/**
 * 直播视频播放时长埋点。
 */
public class VideoPlayDurationData implements IRawData {

    @SerializedName("page")
    public String page;  //格式：/live[/video]/<id

    @SerializedName("playStartTime")
    public long playStartTime;

    @SerializedName("playEndTime")
    public long playEndTime;

    @SerializedName("playDuration")
    public long playDuration;

    @SerializedName("type")
    public int type;//播放类型：正播-101 回放-102

    @Override
    public String toString() {
        return "VideoPlayDurationData{" +
                "page='" + page + '\'' +
                ", playStartTime=" + playStartTime +
                ", playEndTime=" + playEndTime +
                ", playDuration=" + playDuration +
                ", type=" + type +
                '}';
    }
}