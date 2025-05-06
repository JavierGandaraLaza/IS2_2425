package es.unican.is2.practica5b;



import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private InformacionPersonal infoPersonal;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();
    
    private List<Tarjeta> tarjetas = new LinkedList<Tarjeta>();

 	public Cliente(InformacionPersonal infoPersonal) {  
		this.infoPersonal = infoPersonal;
	}
	
 	/**
	public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	*/
	
	public void anhadeCuenta(Cuenta c) {
		Cuentas.add(c);
	}
	
	public void anhadeTarjeta(Tarjeta t) {
		tarjetas.add(t);
		if (t instanceof Debito) {
			Debito td = (Debito)t;
			td.getCuentaAsociada().setCaducidadDebito(td.getCaducidadDebito());
		} else {
			Credito tc = (Credito) t;
			tc.getCuentaAsociada().setCaducidadCredito(tc.getCaducidadCredito());
		}
	}
	
	public double getSaldoTotal() {
		double total = 0.0;
		for (Cuenta c: Cuentas) {  
			if (c instanceof CuentaAhorro) {
				total += ((CuentaAhorro) c).getSaldo();
			} else if (c instanceof CuentaValores)  {
				for (Valor v: ((CuentaValores) c).getValores()) {
					total += v.getCotizacion()*v.getNumValores();
				}
			}
		}
		return total;
	}
	
	/**
	public double getSaldoTotal() {
	    return Cuentas.stream().mapToDouble(Cuenta::getSaldo).sum();
	}
	*/
	
	/**
	public String getNombre() { 
    	return nombre; 
    }
    
    public String getCalle() { 
    	return calle; 
    }
    
    public String getZip() { 
    	return zip; 
    }
    
    public String getLocalidad() { 
    	return localidad; 
    }
    
    public String getTelefono() { 
    	return telefono; 
    }
    
    public String getDni() { 
    	return dni; 
    }
	*/
	
}