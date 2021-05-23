package com.example.photoinspiration;

import com.android.volley.VolleyError;

public class UnsplashAPIListener {

    public interface ResponseListener<T> {
        void onResponse(T response);
    }

    public interface ErrorListener {
        void onErrorResponse(VolleyError error);
    }
}
