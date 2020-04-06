package com.example.lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(){
            calcular()
        }
        btnCalcular.setOnLongClickListener(){
            Toast.makeText(this, "Formula de IMC = peso(kg)/estatura(m)^2", Toast.LENGTH_SHORT).show()
            true
        }

    }

    private fun calcular() {
        var peso = txtpeso.text.toString().toDoubleOrNull()
        var estatura = txtestatura.text.toString().toDoubleOrNull()

        if(peso == null || estatura == null){
            Toast.makeText(this, "Por favor ingrese un valor en el espacio proporcionado", Toast.LENGTH_SHORT).show()
        }else if(peso > 270 || estatura > 270 || peso < 1 || estatura < 1 ){
            Toast.makeText(this, "Por favor ingrese un valor entre 1 y 270", Toast.LENGTH_SHORT).show()
        }else {

            var imc = (peso / 2.25) / ((estatura * estatura) / 100)
            var numero = "%.2f".format(imc)
            val intent = Intent(this, DisplayMessageActivity::class.java)
            intent.putExtra("IMC", numero)
            startActivity(intent)
            finish() // finaliza una actividad
        }
    }

}
