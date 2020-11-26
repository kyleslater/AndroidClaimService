package org.csuf.cs411.simplehttpclient

import android.util.Log
import android.widget.EditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.csuf.cs411.simplehttpclient.Claim
import java.lang.reflect.Type

class ClaimService(val ctx: MainActivity) {

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Service response : ${respStr}")
                ctx.refreshScreen(true)
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("Claim Service", "Failed!")
            ctx.refreshScreen(false)
        }
    }

    fun addClaim(pObj: Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.86.212:8010/ClaimService/add"
        // 1. Convert the pObj into JSON string
        val pJsonString = Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity, "application/json", addServiceRespHandler())
    }
}