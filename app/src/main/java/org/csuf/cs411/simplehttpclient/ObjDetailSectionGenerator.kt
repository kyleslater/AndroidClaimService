package org.csuf.cs411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout
import org.csuf.cs411.simplehttpclient.LableColumnGenerator
import org.csuf.cs411.simplehttpclient.ValueColumnGenerator

class ObjDetailSectionGenerator(val ctx: Context) {
    lateinit var layoutObj: LinearLayout
    fun generate(): LinearLayout {
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)

        //Lablels
        val lcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val colGenerator = LableColumnGenerator(ctx)
        var lblView = colGenerator.generate()
        lcParams.weight = 1.0F
        layoutObj.addView(lblView, lcParams)

        //Values
        val valGenerator = ValueColumnGenerator(ctx)
        val vcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lblView = valGenerator.generate()
        vcParams.marginStart = 5
        vcParams.weight = 3.0F

        layoutObj.addView(lblView, vcParams)

        return layoutObj
    }
}