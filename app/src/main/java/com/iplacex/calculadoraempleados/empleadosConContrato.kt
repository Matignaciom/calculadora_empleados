package com.iplacex.calculadoraempleados

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.iplacex.calculadoraempleados.clases.EmpleadoRegular

class EmpleadosConContrato : AppCompatActivity() {
    private lateinit var sueldoBrutoInput: EditText
    private lateinit var resultadoText: TextView
    private lateinit var calcularButton: Button
    private lateinit var volverButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados_con_contrato)

        sueldoBrutoInput = findViewById(R.id.sueldoBrutoInput)
        resultadoText = findViewById(R.id.resultadoText)
        calcularButton = findViewById(R.id.calcularButton)
        volverButton = findViewById(R.id.volverButton)

        calcularButton.setOnClickListener {
            try {
                val sueldo = sueldoBrutoInput.text.toString().toDoubleOrNull()
                if (sueldo != null) {
                    val empleado = EmpleadoRegular(sueldo)
                    val liquido = empleado.calcularLiquido()
                    resultadoText.text = "Pago Líquido: $liquido"
                } else {
                    resultadoText.text = "Ingrese un sueldo válido"
                }
            } catch (e: Exception) {
                resultadoText.text = "Error: ${e.message}"
            }
        }

        volverButton.setOnClickListener {
            finish()
        }
    }
}
