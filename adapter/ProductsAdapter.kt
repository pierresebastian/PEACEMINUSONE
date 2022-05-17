package com.example.peaceminusone.ui.products.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.peaceminusone.API.data.local.entity.ProductsEntity
import com.example.peaceminusone.R
import com.example.peaceminusone.databinding.AdapterProductsBinding


class ProductsAdapter(private val onBookmarkClick: (ProductsEntity) -> Unit) : ListAdapter<ProductsEntity, ProductsAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = AdapterProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)

        val ivBookmark = holder.binding.ivBookmark
        if (news.isBookmarked) {
            ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    ivBookmark.context,
                    R.drawable.ic_bookmarked_white
                )
            )
        } else {
            ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    ivBookmark.context,
                    R.drawable.ic_bookmark_white
                )
            )
        }
        ivBookmark.setOnClickListener {
            onBookmarkClick(news)
        }
    }

    class MyViewHolder(val binding: AdapterProductsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(products: ProductsEntity) {
            Log.e("Products List : ", products.name)
            binding.tvItemTitle.text = products.name
            Glide.with(itemView.context)
                .load(products.imageUrl)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(binding.imgPoster)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<ProductsEntity> =
            object : DiffUtil.ItemCallback<ProductsEntity>() {
                override fun areItemsTheSame(oldUser: ProductsEntity, newUser: ProductsEntity): Boolean {
                    return oldUser.name == newUser.name
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: ProductsEntity, newUser: ProductsEntity): Boolean {
                    return oldUser == newUser
                }
            }
    }
}