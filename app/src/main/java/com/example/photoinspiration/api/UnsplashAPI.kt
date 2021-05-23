package com.example.photoinspiration.api

import android.content.Context
import android.net.Uri
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.example.photoinspiration.UnsplashAPIListener
import com.example.photoinspiration.UnsplashAPIRequest
import com.example.photoinspiration.UnsplashPhotoList
import com.example.photoinspiration.data.UnsplashPhoto


class UnsplashAPI private constructor(context: Context){

    private val TAG = "UnsplashAPI"
    private val baseURL = "https://api.unsplash.com"
    private val apiUrl: Uri = Uri.parse(baseURL)
    private val requestQueue : RequestQueue = Volley.newRequestQueue(context)

    companion object {
        @Volatile
        private var INSTANCE: UnsplashAPI? = null

        @Synchronized
        fun getInstance(context: Context): UnsplashAPI = INSTANCE ?: UnsplashAPI(context).also { INSTANCE = it }
    }

    fun getListOfPhotos(
        responseListener: UnsplashAPIListener.ResponseListener<UnsplashPhotoList>,
        errorListener: UnsplashAPIListener.ErrorListener
    ) {
        val url = apiUrl?.buildUpon()
            ?.appendPath("photos")
            ?.appendQueryParameter("client_id", "el9gPxhpmlmW11qwMyNyiz3X3llGO1a7GyMxt2TSH-Y")
            ?.build()
            ?.toString()

        val request = UnsplashAPIRequest<Array<UnsplashPhoto>>(
            Request.Method.GET,
            url,
            { response: Array<UnsplashPhoto> -> responseListener.onResponse(UnsplashPhotoList.toUnsplashPhotoList(response)) },
            { error: VolleyError? -> errorListener.onErrorResponse(error) }

        )

        requestQueue.add(request)
    }



}