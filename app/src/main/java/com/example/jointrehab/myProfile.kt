package com.example.jointrehab

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class myProfile : AppCompatActivity() {

    private lateinit var editProfileBtn: LinearLayout
    private lateinit var changePasswordBtn : LinearLayout
    private lateinit var recordsBtn : LinearLayout
    private lateinit var logOutBtn : LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        editProfileBtn = findViewById(R.id.editProfileBtn)
        changePasswordBtn = findViewById(R.id.changePasswordBtn)
        recordsBtn = findViewById(R.id.recordsBtn)
        logOutBtn = findViewById(R.id.logOutBtn)

        recordsBtn.setOnClickListener {
            val intent = Intent(this, data::class.java)
            startActivity(intent)

        editProfileBtn.setOnClickListener {
            val intent = Intent(this, editProfile::class.java)
            startActivity(intent)
        }


        }
    }
}