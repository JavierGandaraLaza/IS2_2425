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
	public Contribuyente contribuyente(String dni) throws DataAccessException {
		return contribuyentesDAO.contribuyente(dni);
	}

	@Override
	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
	    // Verificar si ya existe un contribuyente con el mismo DNI
	    Contribuyente existente = contribuyentesDAO.contribuyente(c.getDni());
	    if (existente != null) {
	        return null; // Ya existe un contribuyente con el mismo DNI
	    }

	    // Registrar el nuevo contribuyente
	    contribuyentesDAO.creaContribuyente(c);

	    return c; // Devuelve el contribuyente registrado
	}
    
	@Override
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
	    // Obtener el contribuyente por su DNI
	    Contribuyente c = contribuyentesDAO.contribuyente(dni);

	    // Si el contribuyente no existe, devolver null
	    if (c == null) {
	        return null;
	    }

	    // Verificar si el contribuyente tiene vehículos a su nombre
	    if (!c.getVehiculos().isEmpty()) {
	        throw new OperacionNoValidaException("El contribuyente tiene vehículos a su nombre");
	    }

	    // Eliminar el contribuyente
	    contribuyentesDAO.eliminaContribuyente(dni);

	    return c; // Devuelve el contribuyente eliminado
	}
    
	@Override
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
	    // Verificar si el contribuyente existe
	    Contribuyente c = contribuyentesDAO.contribuyente(dni);
	    if (c == null) {
	        return null; // No existe el contribuyente
	    }

	    // Verificar si ya existe un vehículo con la misma matrícula
	    Vehiculo existente = vehiculosDAO.vehiculo(v.getId());
	    if (existente != null) {
	        throw new OperacionNoValidaException("Ya existe un vehículo con la misma matrícula");
	    }

	    // Asociar el vehículo al contribuyente
	    c.getVehiculos().add(v);

	    // Registrar el vehículo en el DAO
	    vehiculosDAO.creaVehiculo(v);

	    return v; // Devuelve el vehículo registrado
	}
    
	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
	    // Verificar si el contribuyente existe
	    Contribuyente c = contribuyentesDAO.contribuyente(dni);
	    if (c == null) {
	        return null; // No existe el contribuyente
	    }

	    // Verificar si el vehículo existe
	    Vehiculo v = vehiculosDAO.vehiculoPorMatricula(matricula);
	    if (v == null) {
	        return null; // No existe el vehículo
	    }

	    // Verificar si el vehículo pertenece al contribuyente
	    if (c.buscaVehiculo(matricula) == null) {
	        throw new OperacionNoValidaException("El vehículo no pertenece al contribuyente indicado");
	    }

	    // Eliminar el vehículo del contribuyente
	    c.getVehiculos().remove(v);

	    // Eliminar el vehículo del DAO
	    vehiculosDAO.eliminaVehiculo(matricula);

	    return v; // Devuelve el vehículo eliminado
	}
    
	@Override
	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo) throws OperacionNoValidaException, DataAccessException {
	    // Verificar si el vehículo existe
	    Vehiculo v = vehiculosDAO.vehiculoPorMatricula(matricula);
	    if (v == null) {
	        return false; // No existe el vehículo
	    }

	    // Verificar si el contribuyente actual existe
	    Contribuyente actual = contribuyentesDAO.contribuyente(dniActual);
	    if (actual == null) {
	        return false; // No existe el contribuyente actual
	    }

	    // Verificar si el nuevo contribuyente existe
	    Contribuyente nuevo = contribuyentesDAO.contribuyente(dniNuevo);
	    if (nuevo == null) {
	        return false; // No existe el nuevo contribuyente
	    }

	    // Verificar si el vehículo pertenece al contribuyente actual
	    if (actual.buscaVehiculo(matricula) == null) {
	        throw new OperacionNoValidaException("El vehículo no pertenece al contribuyente actual");
	    }

	    // Cambiar el propietario del vehículo
	    nuevo.getVehiculos().add(v);
	    actual.getVehiculos().remove(v);

	    // Actualizar el vehículo en el DAO
	    vehiculosDAO.actualizaVehiculo(v);

	    return true; // Cambio de titular realizado con éxito
	}
    
    public Contribuyente consultaContribuyente(String dni) throws DataAccessException{
    	return contribuyentesDAO.contribuyente(dni);
    }
    
    public Vehiculo consultaVehiculo(String matricula) throws DataAccessException{
    	return vehiculosDAO.vehiculoPorMatricula(matricula);
    }

	@Override
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
