package es.unican.is2.impuestocirculacionmain;

import es.unican.is2.impuestocirculacionbusiness.*;
import es.unican.is2.impuestocirculaciondaoh2.*;
import es.unican.is2.impuestocirculaciongui.*;

/**
 * Clase principal que construye la aplicaci�n de tres capas y lanza su ejecuci�n
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes capa presentacion
		VistaFuncionario vista = new VistaFuncionario(negocio);
		
		// Lanza ejecuci�n
		vista.setVisible(true);
	}

}
