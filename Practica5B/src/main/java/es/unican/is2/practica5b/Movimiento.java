package es.unican.is2.practica5b;



import java.time.LocalDateTime;

public class Movimiento {
	private String concepto;
	private LocalDateTime fecha;
	private double importe;

	public double getImporte() {
		return importe;
	}

	public void setImporte(double newMImporte) {
		importe = newMImporte;
	}
	
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String newMConcepto) {
		concepto = newMConcepto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime newMFecha) {
		fecha = newMFecha;
	}

	
	@Override
	public boolean equals(Object obj) {
		Movimiento other = (Movimiento)obj;
		return (concepto.equals(other.concepto) && fecha.equals(other.fecha)&& importe==other.importe);
	}
	
}