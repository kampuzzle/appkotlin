package com.example.taxcalc

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taxcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.button2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button2 -> {
                var salary = binding.salary.text.toString().toFloat()
                var expenses = binding.expenses.text.toString().toFloat()

                var valor = salary - expenses
                var aliquota = when (valor) {
                    in (0f..1903.98f) -> {
                        0f
                    }
                    in (1903.99f..2826.65f) -> {
                        7.5f
                    }
                    in (2826.66f..3751.05f) -> {
                        15f
                    }
                    in (3751.06f..4664.68f) -> {
                        22.5f
                    }
                    else -> {
                        27.5f
                    }
                }

                var imposto = valor * (aliquota/100f)
                binding.imposto.text = imposto.toString()
            }
        }
    }
}