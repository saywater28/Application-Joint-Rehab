package com.example.jointrehab

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.jointrehab.models.JointResponse
import com.example.jointrehab.models.Test
import com.example.jointrehab.models.Value
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class data : AppCompatActivity() {

    private lateinit var dot1 : TextView
    private lateinit var dot2 : TextView
    private lateinit var dot3 : TextView
    private lateinit var dot4 : TextView
    private lateinit var dot5 : TextView
    private lateinit var dot6 : TextView
    private lateinit var db : DatabaseReference


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

         lateinit var db: DatabaseReference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        var dot1 = findViewById<TextView>(R.id.sensor01)
        var dot2 = findViewById<TextView>(R.id.sensor2)
        dot3 = findViewById(R.id.sensor3)
        dot4 = findViewById(R.id.sensor4)
        dot5 = findViewById(R.id.sensor5)
        dot6 = findViewById(R.id.sensor6)

        var sensor1 = findViewById<TextView>(R.id.tvSensor1)

        db = FirebaseDatabase.getInstance().getReference("test")

        db.child("json").child("value").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val values = snapshot.getValue<List<Value>>()
                    sensor1.text = values?.get(0)?.readings?.seansor1.toString()

//                    val sensor01 = snapshot.getValue(String::class.java)
                    dot1.text = values?.get(0)?.readings?.seansor1.toString()


                    if (Integer.parseInt(values?.get(0)?.anglex!!) >= 202){
                            dot1.setBackgroundColor(Color.RED)
                        }
                        else if (Integer.parseInt(values.get(0).anglex) < 202 && Integer.parseInt(
                            values.get(0).anglex
                        ) > 88)
                        {
                            dot1.setBackgroundColor(Color.YELLOW)
                        }
                        else {
                            dot1.setBackgroundColor(Color.BLUE)
                        }


//                    for (dataSnapshot in snapshot.children){
//                        id.text = value.anglex

//                        Log.e("@@@", values?.get(0)?.readings?.seansor1.toString())
//                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            }
        )

    }
}