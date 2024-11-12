package com.example.comunicacion_activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserDetailActivity : AppCompatActivity() {

    lateinit var tvUsuario : TextView
    lateinit var btVolver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        tvUsuario = findViewById(R.id.tvUsuario)
        btVolver = findViewById(R.id.btVolver)

        btVolver.setOnClickListener {
            onBackPressed()
        }

        getUserDetails()
    }

    fun getUserDetails() {
        /* Para obtener los datos del intent que creamos en la clase
        * anterior, utilizamos la propiedad intent (No el objeto) junto con us método
        * getStringExtra(String!) en este caso, para obtener el String que cargamos
        * en el origen. El String recibido es la clave que le dimo al dato.*/
        val userName = intent.getStringExtra("USER_NAME")
        tvUsuario.text = userName
    }
}