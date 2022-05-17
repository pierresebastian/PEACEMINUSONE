package com.example.peaceminusone

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout


class SideNavFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_side_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backToMain: ImageView = view.findViewById(R.id.close_side_nav)
        backToMain.setOnClickListener(this)

        val goToHomeScreen: LinearLayout = view.findViewById(R.id.home)
        goToHomeScreen.setOnClickListener(this)

        val goToMenu: LinearLayout = view.findViewById(R.id.menu_side)
        goToMenu.setOnClickListener(this)

        val goToAccount: LinearLayout = view.findViewById(R.id.account_side)
        goToAccount.setOnClickListener(this)

        val goToAbout: LinearLayout = view.findViewById(R.id.aboutus_side)
        goToAbout.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.close_side_nav -> {
                activity?.onBackPressed()
            }
            R.id.home -> {
                val intentHomeScreen = Intent (activity, HomeScreen::class.java)
                activity?.startActivity(intentHomeScreen)
            }
            R.id.menu_side -> {
                val intentNav = Intent (activity, HomeScreen::class.java)
                activity?.startActivity(intentNav)
            }
            R.id.account_side -> {
                val intentNav = Intent (activity, ProfileActivity::class.java)
                activity?.startActivity(intentNav)
            }
            R.id.aboutus_side -> {
                val intentNav = Intent (activity, AboutusActivity::class.java)
                activity?.startActivity(intentNav)
            }
        }
    }

}