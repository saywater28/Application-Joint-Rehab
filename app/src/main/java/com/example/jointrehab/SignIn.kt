package com.example.jointrehab

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var signInBtn: AppCompatButton
    private lateinit var signUpBtn : AppCompatButton
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()

        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)
        signUpBtn = findViewById(R.id.signUpBtn)
        signInBtn = findViewById(R.id.signInBtn)

        signUpBtn.setOnClickListener {
            val intent = Intent(this@SignIn, signUp::class.java)
            startActivity(intent)
        }

        signInBtn.setOnClickListener{
            val editEmail = editEmail.text.toString()
            val editPassword = editPassword.text.toString()

            firebaseAuth.signInWithEmailAndPassword(editEmail, editPassword).addOnCompleteListener {
                if (it.isSuccessful)
                 {
                    val intent = Intent(this@SignIn, myProfile::class.java)
                    startActivity(intent)
                 }
              }
            }
        }

    }
