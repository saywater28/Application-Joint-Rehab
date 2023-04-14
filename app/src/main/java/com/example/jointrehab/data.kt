package com.example.jointrehab

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.jointrehab.models.JointResponse
import com.example.jointrehab.models.Value
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class data : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

         lateinit var db: DatabaseReference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        var sensor1 = findViewById<TextView>(R.id.tvSensor1)

        db = FirebaseDatabase.getInstance().getReference("test")

        db.child("json").child("value").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val values = snapshot.getValue<List<Value>>()
//                    for (dataSnapshot in snapshot.children){

//                        id.text = value.anglex
                        sensor1.text = values?.get(0)?.readings?.seansor1.toString()

//                        Log.e("@@@", values?.get(0)?.readings?.seansor1.toString())
//                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            }
        )

        // Write a message to the database
//        val base = Firebase.databa
//        val myRef = base.getReference("message")

//        val database = FirebaseDatabase.getInstance().reference.child("test").child("")

//        val database = FirebaseDatabase.getInstance().reference.child("test").child("json").child("value")
//        database = Firebase.database.reference
//        val database = FirebaseDatabase.getInstance().reference.child("test").child("json").child("value")

//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // Get Post object and use the values to update the UI
//                val post = dataSnapshot.getValue<JointResponse>()
//                Log.e("@@",post.toString())
//            }

//            override fun onCancelled(databaseError: DatabaseError) {
//                // Getting Post failed, log a message
//                Log.w("@@@", "loadPost:onCancelled", databaseError.toException())
//            }
//        }
//        database.addValueEventListener(postListener)


//        database.addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot?.hasChild("test")!!){
//                    val testData = snapshot.child("test")?.value as JointResponse
//                    Log.e("@@",testData.toString())
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//        val array = database.child("test").child("json").child("value").child("0").get()

//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = dataSnapshot.getValue<String>()
//                Log.d("@@@", "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }

//        })


//        Log.e("@@@",array.toString())

    }
}