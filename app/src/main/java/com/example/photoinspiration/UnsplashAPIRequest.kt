package com.example.photoinspiration

import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.example.photoinspiration.data.UnsplashPhoto
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.UnsupportedEncodingException


class UnsplashAPIRequest<T>(
    method: Int,
    url: String?,
    private val listener: Response.Listener<T>,
    errorListener: Response.ErrorListener?) : Request<T>(method,url,errorListener) {

    private val gson = Gson()

    init {
        setShouldRetryServerErrors(true)
        retryPolicy = DefaultRetryPolicy()
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<T> {
        return try {
            val json = response?.data?.let { String(it) }
            val myObjects: Array<UnsplashPhoto> = gson.fromJson(json, Array<UnsplashPhoto>::class.java)
            Response.success(myObjects as T, HttpHeaderParser.parseCacheHeaders(response))
        }catch (e: UnsupportedEncodingException){
            Response.error(ParseError(e))
        }catch (e: JsonSyntaxException) {
            Response.error(ParseError(e))
        }
    }

    override fun deliverResponse(response: T) {
        listener.onResponse(response)
    }
}