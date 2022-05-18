package com.example.peaceminusone

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class ProfileActivity: AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var password: TextView
    private lateinit var email: TextView
    private lateinit var nomortelp: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore
    private lateinit var userId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

//        val sideNav: ImageView = findViewById(R.id.side_nav)
//        sideNav.setOnClickListener(this)

        auth = Firebase.auth
        fstore = FirebaseFirestore.getInstance()
        userId = auth.currentUser!!.uid

        nama = findViewById(R.id.nama)
        email = findViewById(R.id.email)
        nomortelp = findViewById(R.id.notelp)

        var documentReference: DocumentReference = fstore.collection("User").document(userId)
        documentReference.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("Data Exist", "DocumentSnapshot data: ${document.data}")
                    nama.text = document.getString("nama").toString()
                    email.text = auth.currentUser!!.email.toString()
                    nomortelp.text = document.getString("nomortelepon").toString()

                } else {
                    Log.d("Null", "Data Doesn't Exist")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error", "Failed to get", exception)
            }

    }
}