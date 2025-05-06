package es.unican.is2.practica5b;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> Movimientos;
	private LocalDate caducidadDebito;
	private LocalDate caducidadCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta)  throws datoErroneoException {
		super(numCuenta);
		Movimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}
	
	private Movimiento crearMovimiento(String concepto, double importe) {
	    Movimiento m = new Movimiento();
	    m.setFecha(LocalDateTime.now());
	    m.setConcepto(concepto);
	    m.setImporte(importe);
	    return m;
	}

	public void ingresar(double x) throws datoErroneoException {
		//if (x <= 0)
		//	throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		validarImporte(x);
		
		//Movimiento m = new Movimiento();
		//LocalDateTime now = LocalDateTime.now();
		//m.setFecha(now);
		//m.setConcepto("Ingreso en efectivo");
		//m.setImporte(x);
		
		Movimiento m = crearMovimiento("Ingreso en efectivo", x);
		
		this.Movimientos.add(m);
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		//if (x <= 0)
		//	throw new datoErroneoException("No se puede retirar una cantidad negativa");
		validarImporte(x);
		
		if (getSaldo() < x)
			throw new saldoInsuficienteException("Saldo insuficiente");
		//Movimiento m = new Movimiento();
		//LocalDateTime now = LocalDateTime.now();
		//m.setFecha(now);
		//m.setConcepto("Retirada de efectivo");
		//m.setImporte(-x);
		
		Movimiento m = crearMovimiento("Retirada de efectivo", -x);
		
		this.Movimientos.add(m);
	}

	public void ingresar(String concepto, double x) throws datoErroneoException {
		//if (x <= 0)
		//	throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		validarImporte(x);
		
		validarConcepto(concepto);
		
		//Movimiento m = new Movimiento();
		//LocalDateTime now = LocalDateTime.now();
		//m.setFecha(now);
		//m.setConcepto(concepto);
		//m.setImporte(x);

		Movimiento m = crearMovimiento(concepto, x);
		
		this.Movimientos.add(m);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException {
		if (getSaldo() < x)
			throw new saldoInsuficienteException("Saldo insuficiente");
		//if (x <= 0)
		//	throw new datoErroneoException("No se puede retirar una cantidad negativa");
		validarImporte(x);
		
		validarConcepto(concepto);
		
		//Movimiento m = new Movimiento();
		//LocalDateTime now = LocalDateTime.now();
		//m.setFecha(now);
		//m.setConcepto(concepto);
		//m.setImporte(-x);
		
		Movimiento m = crearMovimiento(concepto, -x);
		
		this.Movimientos.add(m);
	}
	
	/**
	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.Movimientos.size(); i++) {
			Movimiento m = (Movimiento) Movimientos.get(i);
			r += m.getImporte();
		}
		return r;
	}
	*/
	
	public double getSaldo() {
	    return Movimientos.stream().mapToDouble(Movimiento::getImporte).sum();
	}

	public void addMovimiento(Movimiento m) {
		Movimientos.add(m);
	}

	public List<Movimiento> getMovimientos() {
		return Movimientos;
	}

	public LocalDate getCaducidadDebito() {
		return caducidadDebito;
	}

	public void setCaducidadDebito(LocalDate caducidadDebito) {
		this.caducidadDebito = caducidadDebito;
	}

	public LocalDate getCaducidadCredito() {
		return caducidadCredito;
	}

	public void setCaducidadCredito(LocalDate caducidadCredito) {
		this.caducidadCredito = caducidadCredito;
	}

	public double getLimiteDebito() {
		return limiteDebito;
	}

}