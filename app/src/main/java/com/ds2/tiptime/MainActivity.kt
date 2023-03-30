package com.ds2.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ds2.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcularButton.setOnClickListener{calculateTip()}
    }


    fun calculateTip(){
        val stringInTextField = binding.priceInput.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.tip_20_percentage -> 0.2
            R.id.tip_18_percentage -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.simenao.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.gorjetaResultado.text = getString(R.string.quantidade_da_gorjeta, formattedTip)
    }

}

