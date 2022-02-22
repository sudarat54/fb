package com.example.fb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val Firt = pt1.text.toString()
            val Last = pt2.text.toString()

            val fb = FirebaseDatabase.getInstance()
            val ref = fb.getReference("Employee")
            val id: String? = ref.push().key

            val Employee = Employee(id.toString(), Firt, Last)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener {
                Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                pt1.text.clear()
                pt2.text.clear()
            }
        }

        button2.setOnClickListener {
            pt1.text.clear()
            pt2.text.clear()
        }
    }
}
class Employee(val id: String, val firt: String, val last: String) {

}