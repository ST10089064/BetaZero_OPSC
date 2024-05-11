package com.example.settings2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator

class QR : AppCompatActivity() {

    private lateinit var btnScan : Button
    private lateinit var btnBack : Button
    private lateinit var textV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        btnScan = findViewById(R.id.scanner)
        btnBack = findViewById(R.id.qrBack)
        textV = findViewById(R.id.text)

        btnScan.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this@QR)
            intentIntegrator.setOrientationLocked(true)
            intentIntegrator.setPrompt("Scan a QR CODE")
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            intentIntegrator.initiateScan()
        }

        btnBack.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MainActivity::class.java)) })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (intentResult != null) {
            val contents = intentResult.contents
            if (contents != null) {
                textV.text = intentResult.contents
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}