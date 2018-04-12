package io.jiantao.statistics.lib;

/** 统计数据同步接口
 * @author jiantao
 * @param <T> 服务器接收数据格式。 一般为json。
 */
public interface HttpStack<T> {

    /**
     * 同步一部分统计数据
     * @param data
     * @return
     */
    boolean syncData(T data);
}
