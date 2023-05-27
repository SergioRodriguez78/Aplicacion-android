package com.example.primerospasos.primeraApp.ui.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.primerospasos.R
import com.example.primerospasos.databinding.ActivityResultImcBinding

class ResultImc : AppCompatActivity() {
    private lateinit var viewBinding: ActivityResultImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding= ActivityResultImcBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val result= intent.extras?.getDouble(ImcActivity.IMC_KEY) ?: -1.0
        initUi(result)
        viewBinding.tvImc.text= result.toString()

        viewBinding.btnRecalcular.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    private fun initUi(result: Double) {
        when(result){
            in 0.00 ..18.50 ->{
                viewBinding.result.text= "bajo peso"
                viewBinding.result.setTextColor(ContextCompat.getColor(this, R.color.pesobajo))
                    viewBinding.tvDescripcion.text="Estas por debajo del peso para tus parametros"

            }
            in 18.51 ..24.99 ->{
                viewBinding.result.text=" peso normal"
                viewBinding.result.setTextColor(ContextCompat.getColor(this, R.color.pesonormal))
                    viewBinding.tvDescripcion.text="Peso normal para los estandares"

            }
            in 25.00 ..29.99 ->{
                viewBinding.result.text= "alto peso"
                viewBinding.result.setTextColor(ContextCompat.getColor(this, R.color.pesoencima))
                    viewBinding.tvDescripcion.text="tienes un peso mayor al debido"

            }  in 30.00 ..99.00 ->{
                viewBinding.result.text="Obesidad"
            viewBinding.result.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                    viewBinding.tvDescripcion.text="Estas muy por encima de estandares normales"

            }
            else ->{
                viewBinding.result.text="Error"
                    viewBinding.tvImc.text="Error"
                    viewBinding.title.text="Error"
            }

        }

    }


}