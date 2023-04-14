package com.example.jointrehab

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
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        firebaseAuth = FirebaseAuth.getInstance()

        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)

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
