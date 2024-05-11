package com.example.settings2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnAccountSettings : Button
    private lateinit var btnNotifications : Button
    private lateinit var nameTv : TextView
    private lateinit var sharedPrefs : SharedPreferences
    private lateinit var btnScanner : Button
    private lateinit var btnArrowBack : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SharedPreferences
        sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        btnAccountSettings = findViewById(R.id.accountSettings)
        btnNotifications = findViewById(R.id.notifications)
        btnScanner = findViewById(R.id.scanner)

        btnAccountSettings.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity2::class.java)) })

        btnScanner.setOnClickListener(View.OnClickListener { startActivity(Intent(this, QR::class.java)) })


        nameTv = findViewById(R.id.profileName1)

        loadUserData()

    }

    private fun loadUserData() {
        val firstName = sharedPrefs.getString("FIRSTNAME", "")
        val surname = sharedPrefs.getString("SURNAME", "")

        // Set TextView
        nameTv.text = "$firstName $surname"
    }
}