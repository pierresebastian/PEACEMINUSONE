package com.example.peaceminusone.ui.skins.allskins

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.peaceminusone.ui.allproducts.ProductsFragment

class SectionsPagerAdapter internal constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        val fragment = ProductsFragment()
        val bundle = Bundle()
        if (position == 0) {
            bundle.putString(ProductsFragment.ARG_TAB, ProductsFragment.TAB_PRODUCTS)
        } else {
            bundle.putString(ProductsFragment.ARG_TAB, ProductsFragment.TAB_WISHLIST)
        }
        fragment.arguments = bundle
        Log.e("Argument Section : ",fragment.toString())
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}