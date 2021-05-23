package com.example.photoinspiration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoinspiration.PhotoGridAdapter.PhotoViewHolder
import com.example.photoinspiration.data.UnsplashPhoto
import com.squareup.picasso.Picasso
import java.util.*

class PhotoGridAdapter() : RecyclerView.Adapter<PhotoViewHolder>() {

    private var mData: ArrayList<UnsplashPhoto>? = null

    fun setData(data: ArrayList<UnsplashPhoto>){
        this.mData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val p = Picasso.get()
        val photo = mData?.get(position)
//        var width = photo?.width?.div(10)
//        var height = photo?.height?.div(10)
//        if (height != null) {
//            holder.imageView.layoutParams.height = height
//        }
//        if (width != null) {
//            holder.imageView.layoutParams.width = width
//        }
        p.load(photo?.urls?.regular).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return if (mData!=null)  mData!!.size else 0
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.photoItem)

    }
}