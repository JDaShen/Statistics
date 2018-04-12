package io.jiantao.statistics;

import java.util.List;

import io.jiantao.statistics.lib.IDataCache;
import io.jiantao.statistics.sample.BaseData;


/**
 * @author jiantao
 * @date 2018/4/10
 */
public class RealmDataCache implements IDataCache<BaseData> {


    @Override
    public List<BaseData> get(int count) {
        return null;
    }

    @Override
    public void delete(int count) {

    }

    @Override
    public void cache(BaseData data) {

    }
}
