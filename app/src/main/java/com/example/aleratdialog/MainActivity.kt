package com.example.aleratdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btndig1 = findViewById(R.id.btndig1) as Button
        val btndig2 = findViewById(R.id.btndig2) as Button
        val btndig3 = findViewById(R.id.btndig3) as Button

        val addcontact = AlertDialog.Builder(this)
            .setTitle("ADD CONTACT")
            .setMessage("DO you want to add Dheeraj to Your contact")
            .setIcon(R.drawable.ic_addcontact)



            .setPositiveButton("Yes"){_,_ ->

                Toast.makeText(this,"You have added dheeraj to contact",Toast.LENGTH_LONG).show()

            }
            .setNegativeButton("No"){_,_ ->
                Toast.makeText(this,"you didi not add dheeraj to your contact", Toast.LENGTH_SHORT).show()
            }.create()
        btndig1.setOnClickListener(){
            addcontact.show()
        }

        val choose = arrayOf("First item","second item ","third item")
        val dheeraj = AlertDialog.Builder(this)
            .setTitle("Chiose any one")
            .setSingleChoiceItems(choose,0){dialoginterface ,i ->
                Toast.makeText(this,"you choose the ${choose[i]} item",Toast.LENGTH_LONG).show()
            }  .setPositiveButton("Yes"){_,_ ->

                Toast.makeText(this,"You have added dheeraj to contact",Toast.LENGTH_LONG).show()

            }
            .setNegativeButton("No"){_,_ ->
                Toast.makeText(this,"you didi not add dheeraj to your contact", Toast.LENGTH_SHORT).show()
            }.create()

        btndig2.setOnClickListener(){
            dheeraj.show()
        }


         val multidialogarray = AlertDialog.Builder(this)
             .setMultiChoiceItems(choose, booleanArrayOf(false,false,false)){dialogInterface,i,boolischecaked ->
                 if(boolischecaked){
                     Toast.makeText(this,"You have checacked ${choose[i]}",Toast.LENGTH_LONG)
                 }else{
                     Toast.makeText(this,"you hsve un cheacked ${choose[i]}",Toast.LENGTH_SHORT)
                 }


             }
             .setPositiveButton("accept"){_,_ ->
                 Toast.makeText(this,"You have accepted the multidialogarray",Toast.LENGTH_SHORT)

             }
             .setNegativeButton("decline"){_,_ ->
                 Toast.makeText(this,"You have declined the multidialogarray",Toast.LENGTH_SHORT)
             }
        btndig3.setOnClickListener(){
            multidialogarray.show()
        }
    }
}