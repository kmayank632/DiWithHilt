package com.dabodiya.dihilt.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    /** Sum Result */
    private var sum: Int = 0

    /**
     * @param Sum
     * */
    fun setSum(value: Int) {
        sum = value
    }

    /**
     * @return Sum
     * */
    fun getSum() = sum

}