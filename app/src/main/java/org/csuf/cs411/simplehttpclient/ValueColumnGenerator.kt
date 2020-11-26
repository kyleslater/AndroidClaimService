package org.csuf.cs411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop

class ValueColumnGenerator(val ctx: Context) {
    fun generate(): LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        //layoutObj.setBackgroundColor(Color.LTGRAY)

        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        vParams.topMargin = 5
        var value = EditText(ctx)
        value.id = R.id.cTitle
        layoutObj.addView(value, vParams)

        //
        value = EditText(ctx)
        value.id = R.id.date
        layoutObj.addView(value, vParams)

        //Put button here
        var btn = Button(ctx)
        btn.id = R.id.btn
        btn.text = "Add"
        var Bparams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        Bparams.gravity = Gravity.RIGHT
        Bparams.topMargin = 20
        Bparams.bottomMargin = 20
        Bparams.rightMargin = 20



        layoutObj.addView(btn, Bparams)

        //
        value = EditText(ctx)
        value.id = R.id.status
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}