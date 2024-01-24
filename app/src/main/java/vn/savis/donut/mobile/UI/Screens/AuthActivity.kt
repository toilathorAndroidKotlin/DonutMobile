package vn.savis.donut.mobile.UI.Screens

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import vn.savis.donut.mobile.R
import vn.savis.donut.mobile.databinding.ActivityAuthBinding
import vn.savis.donut.mobile.utils.ScreenUtils

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private var isShowPassword: Boolean = false
    private var isShowConfirmPassword: Boolean = false
    private var isSignInTab: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.showConfirmPassword.setOnClickListener {
            if (isShowConfirmPassword) {
                isShowConfirmPassword = false
                binding.edtConfirmPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                isShowConfirmPassword = true
                binding.edtConfirmPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }
        }

        binding.btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.toggleSignUp.setOnClickListener {
            if (isSignInTab) {
                binding.toggleSignUp.isEnabled = false
                binding.toggleSignIn.isEnabled = true
                binding.btnMain.setText(binding.toggleSignUp.text)
                binding.pnConfirmPassword.visibility = VISIBLE
                binding.btnForgotPassword.visibility = GONE
                isSignInTab = !isSignInTab
            }
        }

        binding.toggleSignIn.setOnClickListener {
            if (!isSignInTab) {
                binding.toggleSignUp.isEnabled = true
                binding.toggleSignIn.isEnabled =false
                binding.btnMain.setText(binding.toggleSignIn.text)
                binding.pnConfirmPassword.visibility = GONE
                binding.btnForgotPassword.visibility = VISIBLE
                isSignInTab = !isSignInTab
            }
        }
    }
}