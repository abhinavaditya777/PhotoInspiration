package com.example.photoinspiration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class MainActivity : AppCompatActivity() {
    private var viewModel: PhotoGridViewModel? = null
    private var mPhotoGridRecyclerView : RecyclerView? = null
    private var mPhotoGridAdapter : PhotoGridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPhotoGridRecyclerView = findViewById(R.id.photo_grid_recycler_view)
        mPhotoGridAdapter = PhotoGridAdapter()

        createViewModel()
        observerData()

        viewModel?.loadData()

    }

    private fun createViewModel(){
        viewModel = PhotoGridViewModel(this)
    }

    private fun observerData(){
        mPhotoGridRecyclerView?.adapter = mPhotoGridAdapter
        mPhotoGridRecyclerView?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel?.assetLiveData?.observe(this, {
            if(it.isNotEmpty()){
                mPhotoGridAdapter?.setData(it)
            }
        })
    }
}