package com.example.projetoimc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)


        tvResult.text = String.format("%.2f", result)

        var tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        if (result <18.5) {
            tvClassificacao.text = "Classificação: Abaixo do Peso"
        }
        else if (result >18.5 && result <= 24.9){
            tvClassificacao.text = "Classificação: Normal"
        }
        else if (result in 25.0..29.9){
            tvClassificacao.text = "Classificação: Sobrepeso"
        }
        else if (result in 30.0..39.9){
            tvClassificacao.text = "Classificação: Obesidade"
        }
        else {
            tvClassificacao.text = "Classificação: Obesidade GRAVE III"
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}