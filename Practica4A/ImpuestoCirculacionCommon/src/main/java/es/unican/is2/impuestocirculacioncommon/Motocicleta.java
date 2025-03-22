package es.unican.is2.impuestocirculacioncommon;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo motocicleta
 */
public class Motocicleta extends Vehiculo {

	private int cilindrada;

	public Motocicleta(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, int cilindrada) {
		super(id, matricula, fechaMatriculacion, motor, TipoVehiculo.MOTOCICLETA);
		//TODO
		this.cilindrada = cilindrada;
	}

	/**
	 * Retorna la cilindrada en CC de la motocicleta.
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	@Override
	public double precioImpuesto() {
		//TODO
		double tarifa = 0;

	    // Calcular tarifa básica según la cilindrada
		if (cilindrada <= 125) {
            tarifa = 8;
        } else if (cilindrada <= 250) {
            tarifa = 15;
        } else if (cilindrada <= 500) {
            tarifa = 30;
        } else if (cilindrada <= 1000) {
            tarifa = 60;
        } else {
            tarifa = 120;
        }
		
	    // Aplicar bonificaciones
	    LocalDate fechaActual = LocalDate.now();
	    int añosAntiguedad = fechaActual.getYear() - getFechaMatriculacion().getYear();

	    if (añosAntiguedad > 25) {
	        tarifa *= 0; // 100% de bonificación
	    } else if (getMotor() == TipoMotor.ELECTRICO) {
	        tarifa *= 0.25; // 75% de bonificación
	    } else if (getMotor() == TipoMotor.HIBRIDO && añosAntiguedad < 4) {
	        tarifa *= 0.25; // 75% de bonificación durante los primeros 4 años
	    } else if (getMotor() == TipoMotor.GAS && añosAntiguedad == 0) {
	        tarifa *= 0.5; // 50% de bonificación durante el primer año
	    }

	    return tarifa;
	}

}
