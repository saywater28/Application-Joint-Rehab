package com.example.jointrehab

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class signUp : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var signUpBtn: AppCompatButton
    private lateinit var loginBtn : AppCompatButton
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()


        editName = findViewById(R.id.editName)
        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)
        signUpBtn = findViewById(R.id.signUpBtn)

        loginBtn = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener{
            val intent = Intent(this@signUp, SignIn::class.java)
            startActivity(intent)
        }


        signUpBtn.setOnClickListener {
            val editName = editName.text.toString()
            val editEmail = editEmail.text.toString()
            val editPassword = editPassword.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(editEmail, editPassword).addOnCompleteListener {
                if (it.isSuccessful){
                    data class NewUser(
                        var uid:String?,
                        val displayname: String?,
                        val email:String?,
                        val photourl: String?,
                    )
//                    Toast.makeText(this@signUp, "Clicked", Toast.LENGTH_SHORT).show()
//                    var newuser = NewUser(displayname = editName, email = editEmail, uid = null, photourl = null)
                    val intent = Intent(this@signUp, myProfile::class.java)
                    startActivity(intent)
                }
            }

        }
    }


}