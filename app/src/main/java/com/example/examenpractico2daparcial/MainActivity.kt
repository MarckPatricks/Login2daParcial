package com.example.examenpractico2daparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val miUser = "marcky" // Valor de ejemplo
    private val miContra = "marx1234" // Valor de ejemplo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val inputUser = editTextUsername.text.toString()
            val inputPassword = editTextPassword.text.toString()
            if(inputUser == "" || inputPassword == ""){
                Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
            }else{
                if (miUser == inputUser && miContra == inputPassword) {
                    // Si las credenciales son válidas, redirige a la segunda pantalla

                    val personas = ArrayList<Persona>()
                    personas.add(Persona("Bad", "Bunnys"))
                    personas.add(Persona("Marx", "Marcksito"))

                    val intent = Intent(this, BienvenidaActivity::class.java)
                    intent.putExtra("personas", personas)
                    startActivity(intent)
                } else {
                    // Credenciales incorrectas, muestra un mensaje de error
                    Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}