package impuestocirculacionmain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.impuestocirculacionbusiness.*;
import es.unican.is2.impuestocirculacioncommon.*;
import es.unican.is2.impuestocirculaciondaoh2.*;
import es.unican.is2.impuestocirculaciongui.*;

public class VistaFuncionarioIT {
	
	private FrameFixture window;

	@BeforeEach
    public void init() {
        IContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
        IVehiculosDAO vehiculosDAO = new VehiculosDAO();
        IInfoImpuestoCirculacion info = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
        VistaFuncionario GUI = new VistaFuncionario(info);
        window = new FrameFixture(GUI);
        GUI.setVisible(true);
    }

    @AfterEach
    public void cleanup() {
        window.cleanUp(); 
    }

    @Test
    public void testDNIIncorrectoVacio() {
        // Simulo la interaccion con el botón de busqueda
        JButtonFixture searchButton = window.button("btnBuscar");
        searchButton.requireVisible(); 
        searchButton.click(); 
        
        // Verifico que los campos de texto tienen los valores esperados
        window.textBox("txtNombreContribuyente").requireText("DNI Incorrecto");
        window.textBox("txtTotalContribuyente").requireText("0");
    }
    
    @Test
    public void testDNIFormatoIncorrecto() {
    	// Introduzco un DNI no valido
    	window.textBox("txtDniContribuyente").enterText("123444A");

        JButtonFixture searchButton = window.button("btnBuscar");
        searchButton.requireVisible(); 
        searchButton.click(); 
        
        // Verifico que los campos de texto tienen los valores esperados
        window.textBox("txtNombreContribuyente").requireText("DNI Incorrecto");
        window.textBox("txtTotalContribuyente").requireText("0");
    }
    
    @Test
    public void testbusquedaContribuyente1() throws DataAccessException {
    	window.button("btnBuscar").requireText("Buscar");

    	window.textBox("txtDniContribuyente").enterText("11111111A");

    	window.button("btnBuscar").click();
    	window.textBox("txtNombreContribuyente").requireText("Juan Perez Lopez");
    	window.textBox("txtTotalContribuyente").requireText("206,75");
        
        String[] lst = {"1111AAA", "1111BBB", "1111CCC"};
        assertThat(window.list("listMatriculasVehiculos").contents()).containsExactly(lst);
    }
    
    @Test
    public void testBusquedaContribuyente2() throws DataAccessException {
        window.button("btnBuscar").requireText("Buscar");
        
        window.textBox("txtDniContribuyente").enterText("22222222A");
        
        window.button("btnBuscar").click();
        window.textBox("txtNombreContribuyente").requireText("Ana Cuesta Ruiz");
        window.textBox("txtTotalContribuyente").requireText("223,00");
        
        String[] lst = {"2222AAA"};
        assertThat(window.list("listMatriculasVehiculos").contents()).containsExactly(lst);
    }
 
    @Test
    public void testBusquedaContribuyente3() throws DataAccessException {
        window.button("btnBuscar").requireText("Buscar");
        
        window.textBox("txtDniContribuyente").enterText("33333333A");
       
        window.button("btnBuscar").click();
        window.textBox("txtNombreContribuyente").requireText("Luis Ruiz Rivas");
        window.textBox("txtTotalContribuyente").requireText("0,00"); // No tiene vehiculos
        
        String[] lst = {};
        assertThat(window.list("listMatriculasVehiculos").contents()).containsExactly(lst);
    }

    @Test
    public void testBusquedaContribuyente4() throws DataAccessException {
        window.button("btnBuscar").requireText("Buscar");
        
        window.textBox("txtDniContribuyente").enterText("44444444A");
        
        window.button("btnBuscar").click();
        window.textBox("txtNombreContribuyente").requireText("Pepe Lopez Abascal");
        window.textBox("txtTotalContribuyente").requireText("253,00");
        
        String[] lst = {"4444AAA", "4444BBB"};
        assertThat(window.list("listMatriculasVehiculos").contents()).containsExactly(lst);
    }

}
