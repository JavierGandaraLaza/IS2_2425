package es.unican.is2.impuestocirculacioncommon;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo turismo.
 */
public class Turismo extends Vehiculo {

	private double potencia;
	
	public Turismo(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, double potencia) {
		super(id, matricula, fechaMatriculacion, motor, TipoVehiculo.TURISMO);
		//TODO
		this.potencia = potencia;
	}

	/**
	 * Retorna la potencia en caballos fiscales del vehiculo.
	 */
	public double getPotencia() {
		return potencia;
	}

	@Override
	public double precioImpuesto() {
		//TODO		
		double tarifa = 0;

	    // Calcular tarifa básica según la potencia
		if (potencia < 8) {
            tarifa = 25;
        } else if (potencia < 12) {
            tarifa = 67;
        } else if (potencia < 16) {
            tarifa = 143;
        } else if (potencia < 20) {
            tarifa = 178;
        } else {
            tarifa = 223;
        }

	    // Aplicar bonificaciones
	    LocalDate fechaActual = LocalDate.now();
	    int añosAntiguedad = fechaActual.getYear() - getFechaMatriculacion().getYear();

	    if (añosAntiguedad >= 25) {
	        tarifa *= 0; // 100% de bonificación
	    } else if (getMotor() == TipoMotor.ELECTRICO) {
	        tarifa *= 0.25; // 75% de bonificación
	    } else if (getMotor() == TipoMotor.HIBRIDO && añosAntiguedad < 4) {
	        tarifa *= 0.25; // 75% de bonificación durante los primeros 4 años
	    } else if (getMotor() == TipoMotor.GAS && añosAntiguedad < 1) {
	        tarifa *= 0.5; // 50% de bonificación durante el primer año
	    }

	    return tarifa;
	}

}
