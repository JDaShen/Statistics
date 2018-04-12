package io.jiantao.statistics.lib.imp;

import com.google.gson.annotations.SerializedName;

import io.jiantao.statistics.lib.IRawData;

/**
 * the base data of count: "meta:{}"
 */
public class MetaData implements IRawData {

    @SerializedName("platform")
    public final String platform = "android"; // android / ios

    @SerializedName("deviceId")
    public String deviceId;

    @SerializedName("newDeviceId")
    public String newDeviceId;

    @SerializedName("model")
    public String model;

    @SerializedName("osVersion")
    public String osVersion;

    @SerializedName("sess")
    public String sess;

    @SerializedName("appVersion")
    public String appVersion;

    @SerializedName("channel")
    public String channel; //渠道

    @SerializedName("reporter")
    public final String reporter = "app"; //app,service,web

    @SerializedName("resolution")
    public String resolution;

    @SerializedName("network")
    public String network;

    @SerializedName("userId")
    public String userId;

    @SerializedName("sectionId")
    public int sectionId;     //用户科室

    @SerializedName("type")
    public int type;          //user, type

    /**
     * return this
     */
    public MetaData copyFrom(MetaData src) {
        this.network = src.network;
        this.type = src.type;
        this.sectionId = src.sectionId;
        this.userId = src.userId;
        this.appVersion = src.appVersion;
        this.channel = src.channel;
        this.deviceId = src.deviceId;
        this.model = src.model;
        this.newDeviceId = src.newDeviceId;
        this.osVersion = src.osVersion;
        this.resolution = src.resolution;
        this.sess = src.sess;
        return this;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "platform='" + platform + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", newDeviceId='" + newDeviceId + '\'' +
                ", model='" + model + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", sess='" + sess + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", channel='" + channel + '\'' +
                ", reporter='" + reporter + '\'' +
                ", resolution='" + resolution + '\'' +
                ", network='" + network + '\'' +
                ", userId='" + userId + '\'' +
                ", sectionId=" + sectionId +
                ", type=" + type +
                '}';
    }

}