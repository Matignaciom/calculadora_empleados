package com.iplacex.calculadoraempleados

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iplacex.calculadoraempleados.ui.theme.CalculadoraEmpleadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraEmpleadosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainMenu(this)
                }
            }
        }
    }
}

@Composable
fun MainMenu(context: Context) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Menú Principal", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, CalculoHonorarios::class.java)
            context.startActivity(intent)
        }) {
            Text("Calcular Honorarios")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, EmpleadosConContrato::class.java)
            context.startActivity(intent)
        }) {
            Text("Calcular Empleados con Contrato")
        }
    }
}
