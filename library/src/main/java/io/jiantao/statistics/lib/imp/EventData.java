package io.jiantao.statistics.lib.imp;

import com.google.gson.annotations.SerializedName;

/**
     * 事件數據
     */
    public static class EventData extends BaseData {
        @SerializedName("action")
        public String action;

        @Override
        public String toString() {
            return "EventData{" +
                    "action='" + action + '\'' +
                    "} " + super.toString();
        }
    }