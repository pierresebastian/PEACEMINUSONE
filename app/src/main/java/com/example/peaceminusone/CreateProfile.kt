package com.example.peaceminusone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class CreateProfile : AppCompatActivity(), View.OnClickListener {
    private lateinit var nama: EditText
    private lateinit var password: EditText
    private lateinit var nomortelp: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore
    companion object{
        const val EXTRA_UID = "EXTRA_UID"
        private const val TAG = "Create Profile"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        fstore = FirebaseFirestore.getInstance()
        auth = Firebase.auth
        val submit : Button = findViewById(R.id.btn_submit)
        submit.setOnClickListener(this)



    }

    override fun onClick(v: View) {
       when(v.id){
           R.id.btn_submit -> {
               nama = findViewById(R.id.edt_email_login)
               password = findViewById(R.id.edt_pass_login)
               nomortelp = findViewById(R.id.no_tlp)
               val nama_text = nama.text.toString().trim()
               val password_text = password.text.toString().trim()
               val nomortelp_text = nomortelp.text.toString().trim()
               val userid = auth.currentUser!!.uid
               var documentReference: DocumentReference = fstore.collection("User").document(userid)
               var user: HashMap<String, String> = HashMap<String, String>()
               user.put("nama", nama_text)
               user.put("password", password_text)
               user.put("nomortelepon", nomortelp_text)
               documentReference.set(user).addOnCompleteListener(this){
                   if (it.isSuccessful){
                       Log.d(TAG, "Sukses!!!")
                   }
                   Log.w(TAG, "Gagal!!!!!!!!!!!!!!!")
               }
               val moveintent = Intent(this@CreateProfile, HomeScreen::class.java)
               startActivity(moveintent)
               finish()


           }
       }
    }

}
