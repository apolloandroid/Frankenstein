package com.example.itunesmvp.ui.customView

import android.content.Context
import android.util.AttributeSet

class OtpInputLayout : androidx.appcompat.widget.AppCompatEditText {

    constructor (context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onSelectionChanged(start: Int, end: Int) {
        text?.let {
            if (start != it.length || end != it.length) {
                setSelection(it.length, it.length)
                return
            }
        }
        super.onSelectionChanged(start, end)
    }
}