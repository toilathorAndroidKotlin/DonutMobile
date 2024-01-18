package vn.savis.donut.mobile.utils

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

class ScreenUtils(private val context: Context) {

    /**
     * first is width, second is height
     * */
    fun getScreenSize(): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val display = context.display
            @Suppress("DEPRECATION")
            display?.getRealMetrics(displayMetrics)
        } else {
            @Suppress("DEPRECATION")
            windowManager.defaultDisplay.getMetrics(displayMetrics)
        }

        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels

        return Pair(screenWidth, screenHeight)
    }
}