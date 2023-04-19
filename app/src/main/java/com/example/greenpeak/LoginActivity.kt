package com.example.greenpeak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var edt_Email:EditText
    private lateinit var edt_Password:EditText
    private lateinit var btn_Login:Button
    private lateinit var btn_CreateAcc:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_Email = findViewById(R.id.mEmail)
        edt_Password = findViewById(R.id.mPassword)
        btn_Login = findViewById(R.id.mbtnLogin)
        btn_CreateAcc = findViewById(R.id.mbtnCreate)

        btn_CreateAcc.setOnClickListener {
            var gotomain = Intent(this,MainActivity::class.java)
            startActivity(gotomain)
        }


        btn_Login.setOnClickListener {
            var mail_edt = edt_Email.text.toString().trim()
            var security_edt = edt_Password.text.toString().trim()

            if (mail_edt.isEmpty() || security_edt.isEmpty()){
                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            }
        }

    }
}