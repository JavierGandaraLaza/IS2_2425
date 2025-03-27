package es.unican.is2.impuestocirculacionbusiness;

import es.unican.is2.impuestocirculacioncommon.*;

public class GestionImpuestoCirculacion implements IInfoImpuestoCirculacion, IGestionContribuyentes, IGestionVehiculos {

	private IContribuyentesDAO contribuyentesDAO;
	private IVehiculosDAO vehiculosDAO;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentesDAO, IVehiculosDAO vehiculosDAO) {
		this.contribuyentesDAO = contribuyentesDAO;
		this.vehiculosDAO = vehiculosDAO;
	}
	
	@Override
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		try {
            return vehiculosDAO.vehiculoPorMatricula(matricula);
        } catch (DataAccessException e) {
            throw e;
        }
	}

	@Override
	public Contribuyente contribuyente(String dni) throws DataAccessException {
		try {
            return contribuyentesDAO.contribuyente(dni);
        } catch (DataAccessException e) {
            throw e;
        }
	}

	@Override
	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		try {
			return contribuyentesDAO.creaContribuyente(c);
		} catch (DataAccessException e) {
			throw e;
		}
	}
    
	@Override
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        if (!contribuyente.getVehiculos().isEmpty()) {
            throw new OperacionNoValidaException("El contribuyente tiene vehículos registrados");
        }
        contribuyentesDAO.eliminaContribuyente(dni);
        return contribuyente;
	}
    
	@Override
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        contribuyente.getVehiculos().add(v);
        vehiculosDAO.creaVehiculo(v);
        return v;
	}
    
	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        Vehiculo vehiculo = contribuyente.buscaVehiculo(matricula);
        if (vehiculo == null) {
            throw new OperacionNoValidaException("El vehículo no está registrado a nombre del contribuyente");
        }
        contribuyente.getVehiculos().remove(vehiculo);
        vehiculosDAO.eliminaVehiculo(matricula);
        return vehiculo;
	}
    
	@Override
	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo) throws OperacionNoValidaException, DataAccessException {
		Contribuyente actual = contribuyentesDAO.contribuyente(dniActual);
        Contribuyente nuevo = contribuyentesDAO.contribuyente(dniNuevo);
        if (actual == null || nuevo == null) {
            throw new OperacionNoValidaException("Uno de los contribuyentes no existe");
        }
        Vehiculo vehiculo = actual.buscaVehiculo(matricula);
        if (vehiculo == null) {
            throw new OperacionNoValidaException("El vehículo no está registrado a nombre del contribuyente actual");
        }
        actual.getVehiculos().remove(vehiculo);
        nuevo.getVehiculos().add(vehiculo);
        return true;
	}
    
    public Contribuyente consultaContribuyente(String dni) throws DataAccessException{
    	return contribuyentesDAO.contribuyente(dni);
    }
    
    public Vehiculo consultaVehiculo(String matricula) throws DataAccessException{
    	return vehiculosDAO.vehiculoPorMatricula(matricula);
    }
    
}
