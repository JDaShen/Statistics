package io.jiantao.statistics.lib.util;

import java.util.UUID;

/**
 * @author jiantao
 * @date 2018/4/11
 */
public class Utils {

    /** unique string
     * @return
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    /** 获取当前时间，精确到秒
     * @return
     */
    public static long getCurrentSecondTime(){
        return System.currentTimeMillis()/1000;
    }
}
