package vn.savis.donut.mobile

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import vn.savis.donut.mobile.databinding.ActivityMainBinding
import vn.savis.donut.mobile.utils.ScreenUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isShowPassword: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpBackground()
        setAction()
    }

    private fun setUpBackground() {
        val size = ScreenUtils(context = binding.root.context).getScreenSize()

        val imgBackground1 = ImageView(binding.root.context)
        val imgBackground2 = ImageView(binding.root.context)
        val imgGlazed = ImageView(binding.root.context)

        imgBackground1.setImageResource(R.drawable.img_flag_background)
        imgBackground2.setImageResource(R.drawable.img_flag_background_2)
        imgGlazed.setImageResource(R.drawable.img_glazed)

        val params1 = FrameLayout.LayoutParams(size.first * 711 / 412, size.first * 711 / 412)
        params1.topMargin = -700 * 711 / 412
        params1.leftMargin = -270 * 711 / 412
        imgBackground1.layoutParams = params1

        val params2 = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params2.topMargin = 36
        params2.gravity = Gravity.CENTER_HORIZONTAL
        imgGlazed.layoutParams = params2

        val params3 = FrameLayout.LayoutParams(
            size.first * 400 / 412,
            size.first * 267 / 412
        )
        params3.bottomMargin = -size.first * 97 / 412
        params3.leftMargin = size.first * 102 / 412
        params3.gravity = Gravity.BOTTOM
        imgBackground2.layoutParams = params3

        binding.background.addView(imgBackground1)
        binding.background.addView(imgBackground2)
    }

    private fun setAction() {
        binding.showPassword.setOnClickListener {
            if (isShowPassword) {
                isShowPassword = false
                binding.edtPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                isShowPassword = true
                binding.edtPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }

        }
    }
}