package com.example.projetoimc1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bntCalcular: Button = findViewById(R.id.btnCalcular)
        val edtpeso: EditText = findViewById(R.id.edittext_Peso)
        val edtaltura: SeekBar = findViewById(R.id.editText_Altura)
        val txtaltura: TextView = findViewById(R.id.textViewaltura)

        edtaltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                txtaltura.text = (progress/100.0f).toString()
                // Atualizar o texto da TextView com o valor atual do SeekBar

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Opcional: Lidar com o início do toque no SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Opcional: Lidar com o fim do toque no SeekBar
            }
        })


        bntCalcular.setOnClickListener{

            val alturaStr = txtaltura.text.toString()
            val psoStr = edtpeso.text.toString()

            if(alturaStr.isNotEmpty() && psoStr.isNotEmpty()) {

                val altura: Float=alturaStr.toFloat()
                val peso: Float=psoStr.toFloat()

                val result: Float = peso/(altura*altura)
                //Passando daqui para a activity Result
                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)}

                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show(

                )
            }
        }

    }
}