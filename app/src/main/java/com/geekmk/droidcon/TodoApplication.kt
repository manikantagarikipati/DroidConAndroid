package com.geekmk.droidcon

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //todo perform any of the application level instantiations
    }
}
