package com.iplacex.calculadoraempleados.clases

open class Empleado(protected val sueldoBruto: Double) {
    open fun calcularLiquido(): Double {
        return sueldoBruto
    }
}
