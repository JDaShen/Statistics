package io.jiantao.statistics.lib;

/**
 * @author jiantao
 * @date 2018/4/10
 */
public interface IRawData {

    /**
     * event 事件
     */
    int TYPE_EVENT_DATA = 1;
    /**
     * push 事件
     */
    int TYPE_PUSH_DATA = 2;
    /**
     * 页面停留时长
     */
    int TYPE_ALIVE_DATA = 3;
    /**
     * 页面跳转
     */
    int TYPE_PV_DATA = 4;
    /**
     * 音视频播放时长
     */
    int TYPE_EXT_PLAY_DATA = 5;

}
