package io.jiantao.statistics.lib.util;

import android.support.annotation.NonNull;

/**
 * 实现comparable
 */
class BaseRunnable extends RunnablePool.Runner implements Comparable<BaseRunnable> {

    @Override
    public int compareTo(@NonNull BaseRunnable other) {
        // TODO: 2018/4/6 test prioviry
        return other.getWhat() - this.getWhat();
    }
}