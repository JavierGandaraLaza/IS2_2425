package es.unican.is2.impuestocirculacioncommon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TurismoTest {
	
	private Vehiculo turismo;

	//Potencia <8
	
    @Test
    public void testTurismoPotenciaMenor8_AntiguedadMenor25() {
        turismo = new Turismo(1, "1111AAA", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 7);
        assertTrue(turismo.precioImpuesto() == 25);
    }
    
    @Test
    public void testTurismoPotenciaMenor8_AntiguedadMenor4_Hibrido() {
        turismo = new Turismo(2, "1112BBB", LocalDate.now().minusYears(1), TipoMotor.HIBRIDO, 7);
        assertTrue(turismo.precioImpuesto() == 6.25);
    }
    
    @Test
    public void testTurismoPotenciaMenor8_Electrico() {
        turismo = new Turismo(3, "1113CCC", LocalDate.now().minusYears(10), TipoMotor.ELECTRICO, 7);
        assertTrue(turismo.precioImpuesto() == 6.25);
    }
    
    @Test
    public void testTurismoPotenciaMenor8_AntiguedadMenor1_Gas() {
        turismo = new Turismo(4, "1114DDD", LocalDate.now(), TipoMotor.GAS, 7);
        assertTrue(turismo.precioImpuesto() == 12.5);
    }
    
    @Test
    public void testTurismoPotenciaMenor8_AntiguedadMayor25() {
        turismo = new Turismo(5, "1115EEE", LocalDate.now().minusYears(27), TipoMotor.GASOLINA, 7);
        assertTrue(turismo.precioImpuesto() == 0);
    }
    
    //Potencia >=8 y <12

    @Test
    public void testTurismoPotenciaEntre8y12_AntiguedadMenor25() {
        turismo = new Turismo(6, "2222AAA", LocalDate.now().minusYears(5), TipoMotor.DIESEL, 8);
        assertTrue(turismo.precioImpuesto() == 67);
    }
    
    @Test
    public void testTurismoPotenciaEntre8y12_AntiguedadMenor4_Hibrido() {
        turismo = new Turismo(7, "2223BBB", LocalDate.now().minusYears(2), TipoMotor.HIBRIDO, 9);
        assertTrue(turismo.precioImpuesto() == 16.75);
    }
    
    @Test
    public void testTurismoPotenciaEntre8y12_Electrico() {
        turismo = new Turismo(8, "2224CCC", LocalDate.now().minusYears(5), TipoMotor.ELECTRICO, 10);
        assertTrue(turismo.precioImpuesto() == 16.75);
    }
    
    @Test
    public void testTurismoPotenciaEntre8y12_AntiguedadMenor1_Gas() {
        turismo = new Turismo(9, "2225DDD", LocalDate.now(), TipoMotor.GAS, 11);
        assertTrue(turismo.precioImpuesto() == 33.5);
    }
    
    // Potencia >= 12 y <16

    @Test
    public void testTurismoPotenciaEntre12y16_Antiguedad25() {
        turismo = new Turismo(10, "3333AAA", LocalDate.now().minusYears(25), TipoMotor.HIBRIDO, 12);
        assertTrue(turismo.precioImpuesto() == 0);
    }
    
    @Test
    public void testTurismoPotenciaEntre12y16_AntiguedadMayor4_Hibrido() {
        turismo = new Turismo(11, "3334BBB", LocalDate.now().minusYears(12), TipoMotor.HIBRIDO, 13);
        assertTrue(turismo.precioImpuesto() == 143);
    }
    
    @Test
    public void testTurismoPotenciaEntre12y16_Electrico() {
        turismo = new Turismo(12, "3335CCC", LocalDate.now().minusYears(3), TipoMotor.ELECTRICO, 14);
        assertTrue(turismo.precioImpuesto() == 35.75);
    }
    
    @Test
    public void testTurismoPotenciaEntre12y16_AntiguedadMenor1_Gasolina() {
        turismo = new Turismo(13, "3336DDD", LocalDate.now(), TipoMotor.GASOLINA, 15);
        assertTrue(turismo.precioImpuesto() == 143);
    }
    
    @Test
    public void testTurismoPotenciaEntre12y16_AntiguedadMenor1_Gas() {
        turismo = new Turismo(14, "3336DDD", LocalDate.now(), TipoMotor.GAS, 15);
        assertTrue(turismo.precioImpuesto() == 71.5);
    }
    
    //Potencia >=16 y <20
    
    @Test
    public void testTurismoPotenciaEntre16y20_AntiguedadMenor25() {
        turismo = new Turismo(15, "4444AAA", LocalDate.now().minusYears(6), TipoMotor.GAS, 16);
        assertTrue(turismo.precioImpuesto() == 178);
    }
    
    @Test
    public void testTurismoPotenciaEntre16y20_AntiguedadMenor4_Hibrido() {
        turismo = new Turismo(16, "4445BBB", LocalDate.now().minusYears(1), TipoMotor.HIBRIDO, 17);
        assertTrue(turismo.precioImpuesto() == 44.5);
    }
    
    @Test
    public void testTurismoPotenciaEntre16y20_AntiguedadMenor1_Gas() {
        turismo = new Turismo(17, "4447DDD", LocalDate.now(), TipoMotor.GAS, 18);
        assertTrue(turismo.precioImpuesto() == 89);
    }
    
    //Potencia >=20

    @Test
    public void testTurismoPotenciaMayorOIgual20_AntiguedadMenor25() {
        turismo = new Turismo(18, "5555AAA", LocalDate.now().minusYears(19), TipoMotor.GASOLINA, 20);
        assertTrue(turismo.precioImpuesto() == 223);
    }
    
    @Test
    public void testTurismoPotenciaMayorOIgual20_AntiguedadMenor4_Hibrido() {
        turismo = new Turismo(19, "5556BBB", LocalDate.now().minusYears(3), TipoMotor.HIBRIDO, 21);
        assertTrue(turismo.precioImpuesto() == 55.75);
    }
    
    @Test
    public void testTurismoPotenciaMayorOIgual20_AntiguedadMenor1_Gas() {
        turismo = new Turismo(20, "5557CCC", LocalDate.now(), TipoMotor.GAS, 22);
        assertTrue(turismo.precioImpuesto() == 111.5);
    }
	
}
