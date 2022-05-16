package com.example.peaceminusone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ArchiveActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        val toolbar: Toolbar = findViewById(R.id.app_toolbar_main)
        toolbar.setOnClickListener(this)

        val outwear: ImageButton = findViewById(R.id.button_outerwear)
        outwear.setOnClickListener(this)

        val bottom: ImageButton = findViewById(R.id.button_bottom)
        bottom.setOnClickListener(this)


        val accessories: ImageButton = findViewById(R.id.button_accessories)
        accessories.setOnClickListener(this)
    }

    override fun onClick(v: View) {
            when (v.id) {

                R.id.app_toolbar_main -> {

                }

                R.id.button_outerwear -> {
                    val signInIntent = Intent(this@ArchiveActivity, OutwearActivity::class.java)
                    startActivity(signInIntent)
                }
                R.id.button_bottom -> {
                    val signInIntent = Intent(this@ArchiveActivity, BottomActivity::class.java)
                    startActivity(signInIntent)
                }
                R.id.button_accessories -> {
                    val signInIntent = Intent(this@ArchiveActivity, AccessoriesActivity::class.java)
                    startActivity(signInIntent)
                }
            }
        }
    }

