package io.jiantao.statistics.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.jiantao.statistics.lib.IRawData;

public class BaseData implements IRawData {
    @Expose
    @SerializedName("gUuid")
    public String gUuid;

    @Expose
    @SerializedName("pvUuid")
    public String pvUuid;

    @Expose
    @SerializedName("time")
    public long time;

    // @SerializedName("userStatus")
    // String  userStatus ;


    @Override
    public String toString() {
        return "BaseData{" +
                "gUuid='" + gUuid + '\'' +
                ", pvUuid='" + pvUuid + '\'' +
                ", time=" + time +
                '}';
    }
}