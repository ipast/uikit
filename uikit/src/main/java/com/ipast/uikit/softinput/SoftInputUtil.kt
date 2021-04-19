package com.ipast.uikit.softinput

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * author:chenggang
 * date:2020/7/9
 * description:
 */
object SoftInputUtil {
    /**
     * 隐藏软键盘
     *
     * @param editText
     */
    fun hide(context: Context, editText: EditText) {
        val imm = getInputMethodManager(context)
        if (imm != null) {
            imm.hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }

    fun show(context: Context, editText: EditText) {
        editText.requestFocus()
        editText.postDelayed({
            val imm = getInputMethodManager(context)
            if (imm != null) {
                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
            }
        }, 200)
    }

    fun getInputMethodManager(context: Context): InputMethodManager {
        return context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
}