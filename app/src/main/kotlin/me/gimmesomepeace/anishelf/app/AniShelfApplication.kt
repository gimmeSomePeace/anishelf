package me.gimmesomepeace.anishelf.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import me.gimmesomepeace.anishelf.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class AniShelfApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
