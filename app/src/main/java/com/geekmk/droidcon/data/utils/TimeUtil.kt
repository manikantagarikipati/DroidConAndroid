package com.geekmk.droidcon.data.utils

import java.util.*

class TimeUtil {

    fun getTimeNow():Long{
        return Calendar.getInstance().timeInMillis
    }
}
