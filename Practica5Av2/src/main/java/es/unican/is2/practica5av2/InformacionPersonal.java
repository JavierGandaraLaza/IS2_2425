package es.unican.is2.practica5av2;

public class InformacionPersonal {
	private String nombre;
    private String calle;
    private String zip;;
    private String localidad;
    private String telefono;
    private String dni;

    public InformacionPersonal(String nombre, String calle, String zip, 
                             String localidad, String telefono, String dni) {
        this.nombre = nombre;
        this.calle = calle;
        this.zip = zip;
        this.localidad = localidad;
        this.telefono = telefono;
        this.dni = dni;
    }

    public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
    
    // Getters
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
    
}

