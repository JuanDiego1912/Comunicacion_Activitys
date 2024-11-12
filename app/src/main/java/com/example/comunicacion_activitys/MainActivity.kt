package com.example.comunicacion_activitys

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val usuario : List<User> = listOf(
        User("Juan", "12346789"),
        User("Diego", "9876543211")
    )



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
                /*El Intent solo se usa para pasar datos, la metodología es
                * origen y destino. Este es el origen. Como la clase UserDetailActivity
                * aún no esta cargado en memoria, le indico que es una clase Java.*/
                val intent = Intent(this, UserDetailActivity::class.java)

                /*Cargo en el Objeto Intent un dato String con la clave USER_NAME*/
                intent.putExtra("USER_NAME", etUsuario.text.toString())
                intent.putExtra("USER_AGE", 45)
                intent.putExtra("USER_ALIAS", "JuanDi")
                startActivity(intent)
            }
        }
    }
}