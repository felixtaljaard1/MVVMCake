package com.example.pacticemvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pacticemvvm.databinding.ActivityMainBinding
import com.example.pacticemvvm.databinding.RowCakeBinding
import com.example.pacticemvvm.model.RetrofitServiceItem
import com.example.pacticemvvm.network.RetrofitService

class CakeAdapter : ListAdapter<RetrofitServiceItem, CakeAdapter.MyViewHolder>(SampleItemDiffCallback()){

    class MyViewHolder(val itemBinding: RowCakeBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)

        val binding = RowCakeBinding.inflate(view, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cakeList = getItem(position)
        holder.itemBinding.textView.text = cakeList.title

        Glide.with(holder.itemView.context)
            .load(cakeList.image)
            .into(holder.itemBinding.imageView)
    }
}

class SampleItemDiffCallback : DiffUtil.ItemCallback<RetrofitServiceItem>() {
    override fun areItemsTheSame(oldItem: RetrofitServiceItem, newItem: RetrofitServiceItem): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: RetrofitServiceItem, newItem: RetrofitServiceItem): Boolean = oldItem == newItem

}
