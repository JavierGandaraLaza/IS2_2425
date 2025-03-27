package es.unican.is2.impuestocirculacioncommon;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un vehiculo. 
 * Cada vehiculo tiene una matricula unica.
 */
public abstract class Vehiculo {

	// Clave primaria autogenerada
	private long id;

	private String matricula;
	private LocalDate fechaMatriculacion;
	private TipoMotor motor;
	
	 private TipoVehiculo tipoVehiculo;

	// TODO
	public Vehiculo(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor,
			TipoVehiculo tipoVehiculo) {
		// TODO
		this.id = id;
		this.matricula = matricula;
		this.fechaMatriculacion = fechaMatriculacion;
		this.motor = motor;
		this.tipoVehiculo = tipoVehiculo;
	}

	/**
	 * Retorna la matricula del vehiculo.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna la fecha de primera matriculacion del vehiculo.
	 */
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	/**
	 * Retorna el tipo de motor del vehiculo.
	 */
	public TipoMotor getMotor() {
		return motor;
	}

	/**
	 * Retorna el identificador del vehiculo.
	 */
	public long getId() {
		return id;
	}
	
	public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

	// TODO
	public abstract double precioImpuesto();

}

enum TipoVehiculo {
    TURISMO,
    MOTOCICLETA
}
