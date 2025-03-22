package es.unican.is2.impuestocirculacioncommon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TurismoTest {

	@Test
    void testPrecioImpuestoTurismo() {
        // Caso 1: Turismo con potencia < 8
        Turismo turismo1 = new Turismo(1, "1234ABC", LocalDate.of(2020, 1, 1), TipoMotor.GASOLINA, 7);
        assertEquals(25, turismo1.precioImpuesto());

        // Caso 2: Turismo con potencia entre 8 y 12
        Turismo turismo2 = new Turismo(2, "5678DEF", LocalDate.of(2015, 1, 1), TipoMotor.GASOLINA, 10);
        assertEquals(67, turismo2.precioImpuesto());

        // Caso 3: Turismo con potencia entre 12 y 16
        Turismo turismo3 = new Turismo(3, "9101GHI", LocalDate.of(2010, 1, 1), TipoMotor.GASOLINA, 15);
        assertEquals(143, turismo3.precioImpuesto());

        // Caso 4: Turismo con potencia entre 16 y 20
        Turismo turismo4 = new Turismo(4, "1121JKL", LocalDate.of(2005, 1, 1), TipoMotor.GASOLINA, 18);
        assertEquals(178, turismo4.precioImpuesto());

        // Caso 5: Turismo con potencia >= 20
        Turismo turismo5 = new Turismo(5, "3141MNO", LocalDate.of(2000, 1, 1), TipoMotor.GASOLINA, 25);
        assertEquals(223, turismo5.precioImpuesto());

        // Caso 6: Turismo eléctrico (75% de bonificación)
        Turismo turismo6 = new Turismo(6, "5161PQR", LocalDate.of(2020, 1, 1), TipoMotor.ELECTRICO, 15);
        assertEquals(35.75, turismo6.precioImpuesto());

        // Caso 7: Turismo híbrido (75% de bonificación durante los primeros 4 años)
        Turismo turismo7 = new Turismo(7, "7181STU", LocalDate.of(2022, 1, 1), TipoMotor.HIBRIDO, 15);
        assertEquals(35.75, turismo7.precioImpuesto());

        // Caso 8: Turismo de gas (50% de bonificación durante el primer año)
        Turismo turismo8 = new Turismo(8, "9201VWX", LocalDate.of(2023, 1, 1), TipoMotor.GAS, 15);
        assertEquals(71.5, turismo8.precioImpuesto());

        // Caso 9: Turismo con más de 25 años (100% de bonificación)
        Turismo turismo9 = new Turismo(9, "1221YZA", LocalDate.of(1990, 1, 1), TipoMotor.GASOLINA, 15);
        assertEquals(0, turismo9.precioImpuesto());
    }
	
}
