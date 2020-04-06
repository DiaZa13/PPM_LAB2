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

        var peso = txtpeso.text.toString().toDouble()
        var mass = peso/2.205
        var estatura = txtestatura.text.toString().toDouble()
        var height = estatura/100
        var imc = mass/(height*height)

        var IMC : String = ""
        if(imc < 18.5){
            IMC = 1.toString()
        }else if(imc < 25){
            IMC = 2.toString()
        }else if(imc < 30){
            IMC = 3.toString()
        }else{
            IMC = 4.toString()
        }


        val intent = Intent(this, DisplayMessageActivity::class.java)
        intent.putExtra("IMC",IMC)
        startActivity(intent)
        //finish() // finaliza una actividad
    }

}
