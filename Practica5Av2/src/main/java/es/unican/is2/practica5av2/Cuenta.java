package es.unican.is2.practica5av2;



public class Cuenta {
	
	private String numCuenta;
	
	public Cuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	
	protected final void validarImporte(double importe) throws datoErroneoException {
	    if (importe <= 0) {
	    	throw new datoErroneoException("El importe debe ser positivo");
	    }
	}
	
}
