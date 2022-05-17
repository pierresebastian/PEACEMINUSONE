package com.example.peaceminusone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.peaceminusone.databinding.ActivitySignInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var googleSignInClient:GoogleSignInClient
    private lateinit var binding: ActivitySignInBinding
    private companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.googleSignInButton.setOnClickListener {
            Log.d(TAG, "onCreate: Begin Google Sign In")
            val signInIntent = googleSignInClient.signInIntent
            googleSignInActivityResultLauncher.launch(signInIntent)
        }

    }
    private val googleSignInActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.d(TAG, "onActivityResult : ${result.data!!.extras}")
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    try {
                        val account = task.getResult(ApiException::class.java)
                        Log.d(TAG,"firebaseAuthWithGoogle" + account.id)
                        firebaseAuthWithGoogleAccount(account.idToken!!)
                        //handleSignInResult(task)
                    } catch (e: ApiException) {
                        Log.w(TAG,"Google Sign In Failed", e)
                    }
                }
            } else {
                Log.w(TAG, "onActivityResult : ${result.data}")
            }
        }

    private fun firebaseAuthWithGoogleAccount(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener(this) { task ->
                if (task.additionalUserInfo!!.isNewUser) {
                    /** Akun Baru */
                    updateUI(true)
                } else {
                    /** Akun Lama */
                    updateUI(false)
                }
            }
            .addOnFailureListener { err ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount : ${err.message}")
                Toast.makeText(this, "${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUI(isCreated: Boolean) {
        val user = auth.currentUser!!

        if (isCreated) {
            Log.d(TAG, "firebaseAuthWithGoogleAccount : Account created ${user.email}")
            Toast.makeText(this, "Account created ${user.email}", Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(this, CreateProfile::class.java)
            moveIntent.putExtra(CreateProfile.EXTRA_UID, user.uid)
            startActivity(moveIntent)
            //startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            Log.d(TAG, "firebaseAuthWithGoogleAccount : Existing account ${user.email}")
            Toast.makeText(this, "Existing account ${user.email}", Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(this, HomeScreen::class.java)
            moveIntent.putExtra(HomeScreen.EXTRA_UID, user.uid)
            startActivity(moveIntent)
            //startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

}