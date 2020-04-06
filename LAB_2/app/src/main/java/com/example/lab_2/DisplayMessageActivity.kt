package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    lateinit var IMCImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        IMCImage = findViewById(R.id.IMC_Image)
        val txtresultado = findViewById<TextView>(R.id.txtMensaje1)
        val txtmessage = findViewById<TextView>(R.id.txtMensaje2)
        var resultado = intent.getStringExtra("IMC")
        txtresultado.text = resultado
        var result = resultado.toDouble()

        var last : Int = 0
        if(result < 18.5){
            last = 1
        }else if(result < 25){
            last = 2
        }else if(result < 30){
            last = 3
        }else{
            last =  4
        }

        val drawableResource = when (last) {
            1 -> R.mipmap.desnutricion
            2 -> R.mipmap.ideal
            3 -> R.mipmap.sobrepeso
            else -> R.mipmap.obesidad
        }
        IMCImage.setImageResource(drawableResource)

        if(last == 1){
            txtmessage.text = "Si no come más se va a morir, (está desnutrido)"
        }else if(last == 2){
            txtmessage.text = "Siga así va muy bien. Excelente!! (está en su peso ideal)"
        }else if(last == 3){
            txtmessage.text = "Híjole, hay que bajarle un poquito a la comida, (está en sobrepeso)"
        }else {
            txtmessage.text = "Que buen diente tiene, ya ni modo a hacer ejercicio, (esta en obesidad)"
        }
    }
}
