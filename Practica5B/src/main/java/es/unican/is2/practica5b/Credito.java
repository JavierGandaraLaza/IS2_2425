package es.unican.is2.practica5b;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Credito extends Tarjeta {
	
	private double credito;
	private List<Movimiento> MovimientosMensuales;
	private List<Movimiento> historicoMovimientos;
	
	private static final double COMISION_CAJERO = 0.05;

	public Credito(String numero, String titular, String cvc,
			CuentaAhorro cuentaAsociada, double credito) {
		super(numero, titular, cvc, cuentaAsociada);
		this.credito = credito;
	}
	
	private Movimiento crearMovimiento(String concepto, double importe) {
	    Movimiento m = new Movimiento();
	    m.setFecha(LocalDateTime.now());
	    m.setConcepto(concepto);
	    m.setImporte(importe);
	    return m;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisi�n del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		//if (x<0)
		//	throw new datoErroneoException("No se puede retirar una cantidad negativa");
		validarImporte(x);
		
		/**
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada en cajero");
		*/
		x += x * COMISION_CAJERO; // Comision por operacion con tarjetas credito
		//m.setImporte(-x);
		
		Movimiento m = crearMovimiento("Retirada en cajero", -x);
		
		if (getGastosAcumulados()+x > credito)
			throw new saldoInsuficienteException("Credito insuficiente");
		else {
			MovimientosMensuales.add(m);
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
		//if (x<0)
		//	throw new datoErroneoException("No se puede retirar una cantidad negativa");
		validarImporte(x);
		
		if (getGastosAcumulados() + x > credito)
			throw new saldoInsuficienteException("Saldo insuficiente");
	
		/**
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Compra a credito en: " + datos);
		m.setImporte(-x);
		*/
		
		Movimiento m = crearMovimiento("Compra a credito en: " + datos, -x);
		
		MovimientosMensuales.add(m);
	}
	
    private double getGastosAcumulados() {
		double r = 0.0;
		for (int i = 0; i < this.MovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) MovimientosMensuales.get(i);
			r += m.getImporte();
		}
		return r;
	}
	
	
	public LocalDate getCaducidadCredito() {
		return this.cuentaAsociada.getCaducidadCredito();
	}

	/**
	 * Metodo que se invoca automaticamente el dia 1 de cada mes
	 */
	public void liquidar() {
		//Movimiento liq = new Movimiento();
		//LocalDateTime now = LocalDateTime.now();
		//liq.setFecha(now);
		//liq.setConcepto("Liquidacion de operaciones tarjeta credito");
		double r = 0.0;
		for (int i = 0; i < this.MovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) MovimientosMensuales.get(i);
			r += m.getImporte();
		}
		//liq.setImporte(-r);
		
		Movimiento liq = crearMovimiento("Liquidacion de operaciones tarjeta credito", -r);
	
		if (r != 0)
			cuentaAsociada.addMovimiento(liq);
		
		historicoMovimientos.addAll(MovimientosMensuales);
		MovimientosMensuales.clear();
	}

	public List<Movimiento> getMovimientosMensuales() {
		return MovimientosMensuales;
	}
	
	public List<Movimiento> getMovimientos() {
		return historicoMovimientos;
	}

}