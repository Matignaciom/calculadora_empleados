package com.iplacex.calculadoraempleados.clases

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * (1 - 0.13)
    }
}
