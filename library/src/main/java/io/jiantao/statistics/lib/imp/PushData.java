package io.jiantao.statistics.lib.imp;

import com.google.gson.annotations.SerializedName;

import io.jiantao.statistics.lib.IRawData;

public class PushData implements IRawData {

        @SerializedName("created")
        public long created;       // second
        @SerializedName("userId")
        public String userId;
        @SerializedName("userType")
        public int userType;

        @SerializedName("operationType")
        public int operationType;

        @SerializedName("broadcast")
        public int broadcast;
        @SerializedName("apkType")
        //1(个推)，2(小米)，3(华为)
        public int apkType = 1;
        @SerializedName("pushId")
        public long pushId;

        @SerializedName("data")
        public String data;

        @Override
        public String toString() {
            return "PushData{" +
                    "created=" + created +
                    ", userId='" + userId + '\'' +
                    ", userType=" + userType +
                    ", operationType=" + operationType +
                    ", broadcast=" + broadcast +
                    ", apkType=" + apkType +
                    ", pushId=" + pushId +
                    ", data='" + data + '\'' +
                    '}';
        }
    }