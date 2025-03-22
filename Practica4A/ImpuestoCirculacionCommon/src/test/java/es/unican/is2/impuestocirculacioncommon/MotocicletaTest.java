package es.unican.is2.impuestocirculacioncommon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MotocicletaTest {

	@Test
    void testPrecioImpuestoMotocicleta() {
        // Caso 1: Motocicleta con cilindrada <= 125
        Motocicleta moto1 = new Motocicleta(1, "1234ABC", LocalDate.of(2020, 1, 1), TipoMotor.GASOLINA, 125);
        assertEquals(8, moto1.precioImpuesto());

        // Caso 2: Motocicleta con cilindrada entre 125 y 250
        Motocicleta moto2 = new Motocicleta(2, "5678DEF", LocalDate.of(2015, 1, 1), TipoMotor.GASOLINA, 200);
        assertEquals(15, moto2.precioImpuesto());

        // Caso 3: Motocicleta con cilindrada entre 250 y 500
        Motocicleta moto3 = new Motocicleta(3, "9101GHI", LocalDate.of(2010, 1, 1), TipoMotor.GASOLINA, 400);
        assertEquals(30, moto3.precioImpuesto());

        // Caso 4: Motocicleta con cilindrada entre 500 y 1000
        Motocicleta moto4 = new Motocicleta(4, "1121JKL", LocalDate.of(2005, 1, 1), TipoMotor.GASOLINA, 800);
        assertEquals(60, moto4.precioImpuesto());

        // Caso 5: Motocicleta con cilindrada > 1000
        Motocicleta moto5 = new Motocicleta(5, "3141MNO", LocalDate.of(2000, 1, 1), TipoMotor.GASOLINA, 1200);
        assertEquals(120, moto5.precioImpuesto());

        // Caso 6: Motocicleta eléctrica (75% de bonificación)
        Motocicleta moto6 = new Motocicleta(6, "5161PQR", LocalDate.of(2020, 1, 1), TipoMotor.ELECTRICO, 400);
        assertEquals(7.5, moto6.precioImpuesto());

        // Caso 7: Motocicleta híbrida (75% de bonificación durante los primeros 4 años)
        Motocicleta moto7 = new Motocicleta(7, "7181STU", LocalDate.of(2022, 1, 1), TipoMotor.HIBRIDO, 400);
        assertEquals(7.5, moto7.precioImpuesto());

        // Caso 8: Motocicleta de gas (50% de bonificación durante el primer año)
        Motocicleta moto8 = new Motocicleta(8, "9201VWX", LocalDate.of(2023, 1, 1), TipoMotor.GAS, 400);
        assertEquals(15, moto8.precioImpuesto());

        // Caso 9: Motocicleta con más de 25 años (100% de bonificación)
        Motocicleta moto9 = new Motocicleta(9, "1221YZA", LocalDate.of(1990, 1, 1), TipoMotor.GASOLINA, 400);
        assertEquals(0, moto9.precioImpuesto());
    }
	
}
