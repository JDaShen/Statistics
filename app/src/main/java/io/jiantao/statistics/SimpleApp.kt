package io.jiantao.statistics

import android.app.Application
import io.realm.Realm

/**
 * @author jiantao
 * @date 2018/4/10
 */
class SimpleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}