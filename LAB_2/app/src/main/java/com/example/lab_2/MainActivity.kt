package com.example.lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var imc : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var peso = findViewById<View>(R.id.txtpeso) as EditText
        var estatura = findViewById<View>(R.id.txtestatura) as EditText
        imc = (peso.text.toString().toDouble()/9.8)/(estatura.text.toString().toDouble()*estatura.text.toString().toDouble())
        btnCalcular.setOnClickListener(){
            calcular()
        }

    }

    private fun calcular() {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        intent.putExtra("IMC",imc)
        startActivity(intent)
        //finish() // finaliza una actividad
    }
}
