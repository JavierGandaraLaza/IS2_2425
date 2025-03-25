package es.unican.is2.impuestocirculacioncommon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MotocicletaTest {

	private Vehiculo motocicleta;
	
	@Test
    public void testMotocicletaCilindradaMenorOIgual125() {
        motocicleta = new Motocicleta(1, "1111AAA", LocalDate.now().minusYears(37), TipoMotor.GASOLINA, 1);
        assertTrue(motocicleta.precioImpuesto() == 0);

        motocicleta = new Motocicleta(2, "1112BBB", LocalDate.now().minusYears(2), TipoMotor.HIBRIDO, 50);
        assertTrue(motocicleta.precioImpuesto() == 2);

        motocicleta = new Motocicleta(3, "1113CCC", LocalDate.now().minusYears(10), TipoMotor.ELECTRICO, 50);
        assertTrue(motocicleta.precioImpuesto() == 2);

        motocicleta = new Motocicleta(4, "1114DDD", LocalDate.now(), TipoMotor.GAS, 75);
        assertTrue(motocicleta.precioImpuesto() == 4);

        motocicleta = new Motocicleta(5, "1115EEE", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 125);
        assertTrue(motocicleta.precioImpuesto() == 8);
    }
	
	@Test
    public void testMotocicletaCilindradaMenorOIgual250() {
        motocicleta = new Motocicleta(6, "2222AAA", LocalDate.now().minusYears(37), TipoMotor.GAS, 126);
        assertTrue(motocicleta.precioImpuesto() == 0);

        motocicleta = new Motocicleta(7, "2223BBB", LocalDate.now().minusYears(7), TipoMotor.HIBRIDO, 200);
        assertTrue(motocicleta.precioImpuesto() == 15);

        motocicleta = new Motocicleta(8, "2224CCC", LocalDate.now(), TipoMotor.ELECTRICO, 200);
        assertTrue(motocicleta.precioImpuesto() == 3.75);

        motocicleta = new Motocicleta(9, "2225DDD", LocalDate.now(), TipoMotor.GAS, 225);
        assertTrue(motocicleta.precioImpuesto() == 7.5);

        motocicleta = new Motocicleta(10, "2226EEE", LocalDate.now().minusYears(10), TipoMotor.GAS, 250);
        assertTrue(motocicleta.precioImpuesto() == 15);
    }
	
	@Test
    public void testMotocicletaCilindradaMenorOIgual500() {
        motocicleta = new Motocicleta(11, "3333AAA", LocalDate.now(), TipoMotor.DIESEL, 251);
        assertTrue(motocicleta.precioImpuesto() == 30);

        motocicleta = new Motocicleta(12, "3334BBB", LocalDate.now().minusYears(2), TipoMotor.HIBRIDO, 300);
        assertTrue(motocicleta.precioImpuesto() == 7.5);

        motocicleta = new Motocicleta(13, "3335CCC", LocalDate.now().minusYears(12), TipoMotor.HIBRIDO, 450);
        assertTrue(motocicleta.precioImpuesto() == 30);

        motocicleta = new Motocicleta(14, "3336DDD", LocalDate.now(), TipoMotor.GAS, 500);
        assertTrue(motocicleta.precioImpuesto() == 15);
    }
	
	@Test
    public void testMotocicletaCilindradaMenorOIgual1000() {
        motocicleta = new Motocicleta(15, "4444AAA", LocalDate.now().minusYears(26), TipoMotor.DIESEL, 501);
        assertTrue(motocicleta.precioImpuesto() == 0);

        motocicleta = new Motocicleta(16, "4445BBB", LocalDate.now(), TipoMotor.HIBRIDO, 750);
        assertTrue(motocicleta.precioImpuesto() == 15);

        motocicleta = new Motocicleta(17, "4446CCC", LocalDate.now().minusYears(30), TipoMotor.ELECTRICO, 650);
        assertTrue(motocicleta.precioImpuesto() == 0);

        motocicleta = new Motocicleta(18, "4447DDD", LocalDate.now(), TipoMotor.GAS, 1000);
        assertTrue(motocicleta.precioImpuesto() == 30);
        
        motocicleta = new Motocicleta(19, "4448EEE", LocalDate.now().minusYears(1), TipoMotor.GAS, 1000);
        assertTrue(motocicleta.precioImpuesto() == 60);
    }
	
	@Test
    public void testMotocicletaCilindradaMayor1000() {
        motocicleta = new Motocicleta(20, "5555AAA", LocalDate.now().minusYears(20), TipoMotor.DIESEL, 1001);
        assertTrue(motocicleta.precioImpuesto() == 120);

        motocicleta = new Motocicleta(21, "5556BBB", LocalDate.now().minusYears(3), TipoMotor.HIBRIDO, 1500);
        assertTrue(motocicleta.precioImpuesto() == 30);

        motocicleta = new Motocicleta(22, "5557CCC", LocalDate.now(), TipoMotor.GAS, 1650);
        assertTrue(motocicleta.precioImpuesto() == 60);
    }
	
}
