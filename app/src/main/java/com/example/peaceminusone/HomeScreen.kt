package com.example.peaceminusone

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import com.example.peaceminusone.ui.allproducts.ProductActivity

class HomeScreen : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_UID = "EXTRA_UID"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val sideNav: ImageView = findViewById(R.id.side_nav)
        sideNav.setOnClickListener(this)

        val item: ImageButton = findViewById(R.id.button_item)
        item.setOnClickListener(this)

        val archive: ImageButton = findViewById(R.id.button_archive)
        archive.setOnClickListener(this)

        val about: ImageButton = findViewById(R.id.button_about_us)
        about.setOnClickListener(this)

        val account: ImageButton = findViewById(R.id.cart)
        account.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.side_nav -> {
                val mFragmentManager = supportFragmentManager
                val mSideNavFragment = SideNavFragment()

                val rootView: ViewGroup = findViewById(R.id.main_menu_layout)
                val mFade: androidx.transition.Fade =
                    androidx.transition.Fade(androidx.transition.Fade.IN)
                TransitionManager.beginDelayedTransition(rootView, mFade)

                mFragmentManager
                    .beginTransaction()
                    .add(R.id.main_menu_layout, mSideNavFragment,
                        SideNavFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
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
            R.id.cart -> {
                val signInIntent = Intent(this@HomeScreen, ProfileActivity::class.java)
                startActivity(signInIntent)
            }
        }
    }
}