package com.example.settings2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class usernameEdit : AppCompatActivity() {
    lateinit var eFName : EditText
    lateinit var eSName : EditText
    lateinit var btnSave : Button
    lateinit var btnBack : Button
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_edit)

        //Initialize SharedPreferences
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        //EditText
        eFName = findViewById(R.id.firstName)
        eSName = findViewById(R.id.lastName)

        //Button
        btnSave = findViewById(R.id.usernameSave)
        btnBack = findViewById(R.id.usernameBack)

        //Load data from SharedPreferences
        loadUserData()

        btnSave.setOnClickListener {
            //get data from text
            var firstName = eFName.text.toString()
            var surname = eSName.text.toString()

            //Save data to SharedPreferences
            saveUserData(firstName, surname)

            //activity intent
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("FIRSTNAME", firstName)
            intent.putExtra("SURNAME", surname)
            startActivity(intent)

            finish()
        }
        btnBack.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity2::class.java)) })
    }

    private fun saveUserData(firstName: String, surname: String){
        val editor = sharedPrefs.edit()
        editor.putString("FIRSTNAME", firstName)
        editor.putString("SURNAME", surname)
        editor.apply()
    }

    private fun loadUserData(){
        val firstName = sharedPrefs.getString("FIRSTNAME", "")
        val surname = sharedPrefs.getString("SURNAME", "")

        //set EditText fields
        eFName.setText(firstName)
        eSName.setText(surname)
    }
}