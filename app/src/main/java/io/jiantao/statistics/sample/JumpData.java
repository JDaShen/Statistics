package io.jiantao.statistics.sample;

import com.google.gson.annotations.SerializedName;

/**
 * 跳转数据
 */
public class JumpData extends BaseData {

    @SerializedName("from")
    public String from;

    @SerializedName("to")
    public String to;

    @Override
    public String toString() {
        return "JumpData{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                "} " + super.toString();
    }
}