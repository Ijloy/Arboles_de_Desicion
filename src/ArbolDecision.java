public class ArbolDecision {

    // Árbol de decisión manual (7/10)
    public static String evaluarPrestamo(double ingreso,
                                         double monto,
                                         boolean tieneDeudas,
                                         boolean buenHistorial) {

        // NODO RAÍZ: historial crediticio
        if (!buenHistorial) {
            return "PRÉSTAMO RECHAZADO\nMotivo: Mal historial crediticio";
        }

        // SEGUNDO NIVEL: ingresos
        if (ingreso < 800) {
            return "PRÉSTAMO RECHAZADO\nMotivo: Ingresos insuficientes";
        }

        // TERCER NIVEL: relación monto / ingreso
        if (monto > ingreso * 10) {
            return "PRÉSTAMO RECHAZADO\nMotivo: Monto solicitado demasiado alto";
        }

        // CUARTO NIVEL: deudas
        if (tieneDeudas) {
            if (monto > ingreso * 5) {
                return "PRÉSTAMO RECHAZADO\nMotivo: Deudas activas y alto riesgo";
            } else {
                return "PRÉSTAMO APROBADO\nCondición: Monto limitado";
            }
        }

        // HOJA FINAL
        return "PRÉSTAMO APROBADO\nCondición: Monto completo";
    }
}
