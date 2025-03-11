package es.unican.is2.ImpuestoCirculacionBusiness;

import java.time.LocalDate;

import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.DataAccessException;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionCommon.TipoMotor;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;
import es.unican.is2.ImpuestoCirculacionDAOH2.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAOH2.VehiculosDAO;

public class GestionImpuestoCirculacion implements IInfoImpuestoCirculacion {

	public GestionImpuestoCirculacion(ContribuyentesDAO contribuyentesDAO, VehiculosDAO vehiculosDAO) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contribuyente contribuyente(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

    public boolean altaContribuyente(String nombre, String apellidos, String dni) {
    	throw new UnsupportedOperationException("Unimplemented method 'altaContribuyente'");
    }
    
    public boolean bajaContribuyente(String dni) {
    	throw new UnsupportedOperationException("Unimplemented method 'bajaContribuyente'");
    }
    
    public boolean altaVehiculo(String matricula, LocalDate fechaMatriculacion, TipoMotor motor, double potencia, String dni) {
    	throw new UnsupportedOperationException("Unimplemented method 'altaVehiculo'");
    }
    
    public boolean bajaVehiculo(String matricula, String dni) {
    	throw new UnsupportedOperationException("Unimplemented method 'bajaVehiculo'");
    }
    
    public boolean cambiaTitular(String matricula, String dniActual, String dniNuevo) {
    	throw new UnsupportedOperationException("Unimplemented method 'cambiaTitular'");
    }
    
    public Contribuyente consultaContribuyente(String dni) {
    	throw new UnsupportedOperationException("Unimplemented method 'consultaContribuyente'");
    }
    
    public Vehiculo consultaVehiculo(String matricula) {
    	throw new UnsupportedOperationException("Unimplemented method 'consultaVehiculo'");
    }
    
}
