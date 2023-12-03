package com.example.primerospasos.primeraApp.ui.imc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ActivityImcBinding
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityImcBinding

    private var weight: Int = 70
    private var height: Int = 120
    private var age: Int = 40

    companion object {
        const val IMC_KEY = "imc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        viewBinding = ActivityImcBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.viewMale.setOnClickListener {
            changeColorMale()
        }
        viewBinding.vieFemale.setOnClickListener {
            changeColorFemale()
        }

        viewBinding.RSHeight.addOnChangeListener { _, value, _ ->

            height = value.toInt()

            viewBinding.heigh.text = "$height cm"
        }

        viewBinding.btnSum.setOnClickListener {
            weight += 1

            setTextWeight(weight)
        }

        viewBinding.btnSubstract.setOnClickListener {
            weight -= 1

            setTextWeight(weight)
        }
        viewBinding.btnSumAge.setOnClickListener {
            age += 1

            setTextAge(age)
        }

        viewBinding.btnSubstractAge.setOnClickListener {
            age -= 1

            setTextAge(age)
        }
        viewBinding.btnCalcular.setOnClickListener {
            navigateToResult(
                calculateImc()
            )
        }

    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultImc::class.java).putExtra("imc", result)
        startActivity(intent)
    }

    private fun calculateImc(): Double {
        val format = DecimalFormat("#.##")
        val imc = weight / (height.toDouble() / 100 * height.toDouble() / 100)

        return format.format(imc).toDouble()

    }

    private fun setTextWeight(weight: Int) {
        viewBinding.weight.text = "$weight Kg"
    }

    private fun setTextAge(age: Int) {
        viewBinding.age.text = "$age Años"
    }

    private fun changeColorMale() {
        viewBinding.viewMale.setCardBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.background_selected
            )
        )
        viewBinding.vieFemale.setCardBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.background_component
            )
        )

    }

    private fun changeColorFemale() {
        viewBinding.viewMale.setCardBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.background_component
            )
        )
        viewBinding.vieFemale.setCardBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.background_selected
            )
        )
    }
}
