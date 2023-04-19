package com.example.greenpeak

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtFirstName:EditText
    private lateinit var edtSecondName:EditText
    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btn_account:Button
    private lateinit var btn_log:Button
    private lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtFirstName = findViewById(R.id.mEdtFirstName)
        edtSecondName = findViewById(R.id.mEdtSecondName)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPassword = findViewById(R.id.mEdtPassword)
        btn_account = findViewById(R.id.mbtnAccount)
        btn_log = findViewById(R.id.log)

        btn_log.setOnClickListener {

            var gotologin = Intent(this,LoginActivity::class.java)
            startActivity(gotologin)

        }

       db = openOrCreateDatabase("ChrisDB", Context.MODE_PRIVATE, null)

       db.execSQL("CREATE TABLE IF NOT EXISTS users(jinakwanza VARCHAR, jinapili VARCHAR, arafa VARCHAR, pass VARCHAR)")

       btn_account.setOnClickListener {
           var jinakwanza_edt = edtFirstName.text.toString().trim()
           var jinapili_edt = edtSecondName.text.toString().trim()
           var arafa_edt = edtEmail.text.toString().trim()
           var pass_edt = edtPassword.text.toString().trim()


           //validation

           if (jinakwanza_edt.isEmpty() || jinapili_edt.isEmpty() || arafa_edt.isEmpty() || pass_edt.isEmpty()) {
               Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
           } else{
               db.execSQL("INSERT INTO users VALUES( '\"+jinakwanza_edt+\"','\"+jinapili_edt+\"','\"+arafa_edt+\"','\"+pass_edt+\"')")
               Toast.makeText(this, "Data has been saved successfully", Toast.LENGTH_SHORT).show()

               var gotologin = Intent(this,LoginActivity::class.java)
               startActivity(gotologin)
           }
       }





    }
}