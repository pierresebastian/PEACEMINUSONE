package com.example.peaceminusone

import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity: AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var password: TextView
    private lateinit var nomortelp: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore
}