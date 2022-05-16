package com.example.peaceminusone

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class WishlistActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

//        val toolBar: ImageView = findViewById(R.id.app_toolbar_main)
//        setSupportActionBar(toolBar)

        val archive: ImageButton = findViewById(R.id.app_toolbar_main)
        archive.setOnClickListener(this)

        val item: ImageButton = findViewById(R.id.button_item)
        item.setOnClickListener(this)

        val about: ImageButton = findViewById(R.id.button_about_us)
        about.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}