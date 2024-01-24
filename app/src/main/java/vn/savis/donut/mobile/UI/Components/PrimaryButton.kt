package vn.savis.donut.mobile.UI.Components

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import vn.savis.donut.mobile.R

class PrimaryButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var button: Button
    init {
        inflate(context, R.layout.primary_button, this)
        button = findViewById(R.id.buttonPrimary)
        attrs?.let { setAttributes(context, it) }
    }

    private fun setAttributes(context: Context, attrs: AttributeSet) {
        attrs.let {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PrimaryButton)
            typedArray.getString(R.styleable.PrimaryButton_android_text)?.let {
                this.button.text = it
            }
            typedArray.recycle()
        }
    }

    fun setText(text: CharSequence) {
        this.button.text = text
    }

    override fun setOnClickListener(l: OnClickListener?) {
        this.button.setOnClickListener(l)
    }
}