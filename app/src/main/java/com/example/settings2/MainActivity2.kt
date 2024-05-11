package com.example.settings2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView

class MainActivity2 : AppCompatActivity() {

    private lateinit var btnCProfile : FloatingActionButton
    private lateinit var profilePic : ImageView
    private lateinit var btnChangeName : Button
    private lateinit var nameTv : TextView
    private lateinit var btnPassword : Button
    private lateinit var sharedPrefs : SharedPreferences
    private lateinit var btnArrowBack : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Intialize SharedPreferences
        sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        btnCProfile = findViewById(R.id.cameraFloatingActionButton)
        profilePic = findViewById(R.id.profileImage2)
        btnChangeName = findViewById(R.id.accountUsername)
        btnPassword = findViewById(R.id.password_change)
        btnArrowBack = findViewById(R.id.backFloat)


        btnCProfile.setOnClickListener {
            pickImage()
        }

        btnChangeName.setOnClickListener(View.OnClickListener { startActivity(Intent(this, usernameEdit::class.java)) })


        //Textview
        nameTv = findViewById(R.id.profileName)

        //Load user data
        loadUserData()

        btnPassword.setOnClickListener(View.OnClickListener { startActivity(Intent(this, PasswordChange::class.java)) })

        btnArrowBack.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity::class.java)) })

    }

    private fun loadUserData(){
        val firstName = sharedPrefs.getString("FIRSTNAME", "")
        val surname = sharedPrefs.getString("SURNAME", "")

        //set Textview
        nameTv.text = "$firstName $surname"
    }



    fun pickImage(){
        val intent = Intent(MediaStore.ACTION_PICK_IMAGES)
        startActivityForResult(intent, 101)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            if(requestCode == 101){
                val uri = data?.data
                profilePic.setImageURI(uri)
            }
        }
    }
}