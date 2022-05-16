package com.example.peaceminusone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.example.peaceminusone.ui.allproducts.ProductActivity

class HomeScreen : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_UID = "EXTRA_UID"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

//        val toolBar: ImageView = findViewById(R.id.app_toolbar_main)
//        setSupportActionBar(toolBar)

        val toolbar: Toolbar = findViewById(R.id.app_toolbar_main)
        toolbar.setOnClickListener(this)

        val item: ImageButton = findViewById(R.id.button_item)
        item.setOnClickListener(this)

        val archive: ImageButton = findViewById(R.id.button_archive)
        archive.setOnClickListener(this)


        val about: ImageButton = findViewById(R.id.button_about_us)
        about.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.app_toolbar_main -> {

            }

            R.id.button_item -> {
                val signInIntent = Intent(this@HomeScreen, ProductActivity::class.java)
                startActivity(signInIntent)
            }
            R.id.button_archive -> {
                val signInIntent = Intent(this@HomeScreen, ArchiveActivity::class.java)
                startActivity(signInIntent)
            }
            R.id.button_about_us -> {
                val signInIntent = Intent(this@HomeScreen, AboutusActivity::class.java)
                startActivity(signInIntent)
            }
        }
    }
}