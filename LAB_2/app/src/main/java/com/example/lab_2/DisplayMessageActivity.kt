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

        val txtresultado = findViewById<TextView>(R.id.txtMensaje1)
        var resultado = intent.getStringExtra("IMC")
        txtresultado.text = resultado
        var result = resultado.toInt()

        IMCImage = findViewById(R.id.IMC_Image)

        val drawableResource = when (result) {
            1 -> R.mipmap.desnutricion
            2 -> R.mipmap.ideal
            3 -> R.mipmap.sobrepeso
            else -> R.mipmap.obesidad
        }

        IMCImage.setImageResource(drawableResource)



    }
}
