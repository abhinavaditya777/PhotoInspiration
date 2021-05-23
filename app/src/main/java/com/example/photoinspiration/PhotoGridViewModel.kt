package com.example.photoinspiration

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photoinspiration.api.UnsplashAPI
import com.example.photoinspiration.data.UnsplashPhoto
import java.util.*

//class PhotoGridViewModelFactory(
//    private val context: Context
//) : ViewModelProvider.NewInstanceFactory() {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return PhotoGridViewModel(context) as T
//    }
//}

class PhotoGridViewModel(private val context: Context) : ViewModel() {
    var assetLiveData : MutableLiveData<ArrayList<UnsplashPhoto>>? = MutableLiveData()

    internal fun loadData(){
        UnsplashAPI.getInstance(context).getListOfPhotos(
            {
                assetLiveData?.postValue(it?.unsplashPhotoList ) },
            {}
        )
    }
}