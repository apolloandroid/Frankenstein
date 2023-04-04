package com.example.itunesmvp.ui.customView

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.core.widget.doAfterTextChanged
import com.example.itunesmvp.R
import com.google.android.material.textfield.TextInputLayout

class OtpLayout : LinearLayout {

    private lateinit var layoutContainer: LinearLayout
    private lateinit var inputLayouts: List<TextInputLayout>
    private lateinit var editTexts: List<EditText>

    constructor (context: Context?) : super(context) {
        this.initViews()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        this.initViews()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.initViews()
    }

    fun setError() {
        inputLayouts.forEach {
            it.isErrorEnabled = true
            // change this error message
            it.error = "error"
        }
    }

    private fun initViews() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_otp_layout, this)
        layoutContainer = findViewById<LinearLayout>(R.id.layoutRoot)
        inputLayouts = layoutContainer.children.map { it as TextInputLayout }.toList()
        editTexts = inputLayouts.mapNotNull { it.editText }.toList()

        setColorStateList()
        setOnTextChangedListeners()
        setOnKeyListeners()
        setOnFocusChangedListeners()
    }

    private fun setColorStateList() = inputLayouts.forEach { layout ->
        val mainColor = layout.boxStrokeColor
        val defaultColor = R.color.color_6F7975

        val states = arrayOf(
            intArrayOf(android.R.attr.state_focused),
            intArrayOf(android.R.attr.state_hovered),
            intArrayOf(android.R.attr.state_enabled),
            intArrayOf()
        )

        val colors = intArrayOf(mainColor, mainColor, mainColor, defaultColor)
        val colorStateList = ColorStateList(states, colors)
        layout.setBoxStrokeColorStateList(colorStateList)
    }

    private fun setOnTextChangedListeners() = editTexts.forEachIndexed { index, editText ->
        editText.doAfterTextChanged { text ->
            inputLayouts.forEach { it.isErrorEnabled = false }
            if (text.toString().isNotEmpty()) {
                if (index != editTexts.count() - 1) {
                    val nextEditText = editTexts[index + 1]
                    nextEditText.requestFocus()
                }
            }
        }
    }

    private fun setOnKeyListeners() = editTexts.forEachIndexed { index, editText ->
        editText.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && editText.text.isEmpty() && index != 0) {
                val previousEditText = editTexts[index - 1]
                previousEditText.requestFocus()
            }
            false
        }
    }

    private fun setOnFocusChangedListeners() = editTexts.forEachIndexed { index, editText ->
        val parentLayout = inputLayouts[index]
        val defaultStrokeWidth = parentLayout.boxStrokeWidth
        editText.setOnFocusChangeListener { _, hasFocus ->
            editText.post { editText.setSelection(editText.text.length) }
            if (!hasFocus) {
                parentLayout.isHovered = editText.text.isNotEmpty()
                parentLayout.boxStrokeWidth = if (editText.text.isEmpty()) defaultStrokeWidth
                else parentLayout.boxStrokeWidthFocused
            }
        }
    }
}