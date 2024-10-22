package com.iplacex.calculadoraempleados.clases

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * (1 - 0.20)
    }
}
