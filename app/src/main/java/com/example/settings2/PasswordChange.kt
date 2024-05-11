package com.example.settings2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PasswordChange : AppCompatActivity() {

    private lateinit var btnSave : Button
    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        btnSave = findViewById(R.id.passwordSave)
        btnBack = findViewById(R.id.passwordBack)

        btnSave.setOnClickListener(){
            finish()
        }

        btnBack.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity2::class.java)) })
    }
}