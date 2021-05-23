package com.example.photoinspiration

import com.example.photoinspiration.data.UnsplashPhoto

class UnsplashPhotoList {
    val unsplashPhotoList = ArrayList<UnsplashPhoto>()

    companion object {
        fun toUnsplashPhotoList(response: Array<UnsplashPhoto>) : UnsplashPhotoList{
            val photoList = UnsplashPhotoList()
            for(photo in response){
                photoList.unsplashPhotoList.add(photo)
            }
            return photoList
        }
    }
}