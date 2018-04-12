package io.jiantao.statistics.lib;

import java.util.List;

/**
 * @author jiantao
 * @param <T> 持久化的数据类型
 * @param <K> 统计数据字典
 */
public interface IDataCache<T, K extends IRawData> {

    /**
     * 获取最早缓存的count条数据
     *
     * @param count 最大条数
     * @return
     */
    List<T> get(int count);

    void delete(int count);

    void cache(K data);

    String convert(List<T> list);

    K createRawData(int dataType);
}
