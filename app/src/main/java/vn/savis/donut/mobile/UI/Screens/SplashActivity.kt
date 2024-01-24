package vn.savis.donut.mobile.UI.Screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import vn.savis.donut.mobile.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val handler = Handler(Looper.getMainLooper())
        var elapsedTime = 0L
        val tick = 10
        val duration = 1000f
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Thực hiện hành động mỗi 1ms ở đây
                println("Doing something at $elapsedTime ms")
                binding.progressBar.progress = (elapsedTime / duration * 100).toInt()

                // Tăng thời gian đã trôi qua
                elapsedTime += tick

                // Kiểm tra xem đã đạt đến tổng thời gian 3 giây chưa
                if (elapsedTime < duration) {
                    // Tiếp tục vòng lặp
                    handler.postDelayed(this, tick.toLong())
                } else {
                    // Kết thúc vòng lặp sau khi đạt đến 3 giây
                    binding.progressBar.progress = 100
                    go2MainActivity()
                }
            }
        }, tick.toLong())
    }

    private fun go2MainActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}