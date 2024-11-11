package com.example.comunicacion_activitys

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
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

        val btAceptar = findViewById<Button>(R.id.btAceptar)
        val etUsuario = findViewById<TextView>(R.id.etUsuario)

        btAceptar.setOnClickListener {
            if (etUsuario.text.isBlank()) {
                Toast.makeText(this,
                    "Introduzca un usuario.",
                    Toast.LENGTH_SHORT).show()
            } else {
                /* Crear un bundle y meteremos un nmbre y valor, par clave valor,
                * lo enviamos a donde querramos, la otra activity*/
            }
        }
    }
}