package io.jiantao.statistics.lib.imp;

import com.google.gson.annotations.SerializedName;

/**
 * 时长数据
 */
public class OnlineData extends BaseData {

    @SerializedName("duration")
    public long duration;   //停留時長

    @Override
    public String toString() {
        return "OnlineData{" +
                "duration=" + duration +
                "} " + super.toString();
    }
}