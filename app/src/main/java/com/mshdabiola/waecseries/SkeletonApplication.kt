package com.mshdabiola.waecseries

import android.app.Application
import com.mshdabiola.worker.Saver
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SkeletonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Saver.initialize(this)

        if(packageName.contains("debug")) {
            Timber.plant(Timber.DebugTree())
            Timber.e("log on app create")
        }
    }
}
