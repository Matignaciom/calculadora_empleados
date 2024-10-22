package com.iplacex.calculadoraempleados

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.iplacex.calculadoraempleados.ui.theme.CalculadoraEmpleadosTheme
import com.iplacex.calculadoraempleados.clases.EmpleadoHonorarios

@OptIn(ExperimentalMaterial3Api::class)
class CalculoHonorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraEmpleadosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HonorariosScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HonorariosScreen() {
    val context = LocalContext.current
    var sueldoBruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0.0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Cálculo de Honorarios", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text("Sueldo Bruto") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val sueldo = sueldoBruto.toDoubleOrNull()
            if (sueldo != null) {
                val empleado = EmpleadoHonorarios(sueldo)
                resultado = empleado.calcularLiquido()
            }
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Pago Líquido: ${resultado}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            (context as? Activity)?.finish()
        }) {
            Text("Volver al Menú")
        }
    }
}
