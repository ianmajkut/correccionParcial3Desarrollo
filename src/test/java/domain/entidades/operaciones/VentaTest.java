package domain.entidades.operaciones;

import domain.entidades.operaciones.estados.Concretada;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VentaTest extends OperacionTest {

    @Before
    public void init() {
        super.init();
    }

    @Test
    public void ventaDeCasaConComisionDe20PorcQueDa12K(){
        Venta.setPorcentajeSobreInmueble(0.2);
        Venta unaVenta = new Venta();
/*
        Empleado unEmpleado = new Empleado();
        unEmpleado.setNombre("Sergio");
        unEmpleado.setApellido("Ramos");

        Cliente unCliente = new Cliente();
        unCliente.setNombre("Leo");
        unCliente.setApellido("Messi");

        //Concretada estadoConcretado = new Concretada();
        //estadoConcretado.concretar(unaVenta, unCliente, unEmpleado);
*/
        unaVenta.setInmueble(super.unaCasa);

        Double valorEsperado = 12000.0;

        Assert.assertEquals(valorEsperado, unaVenta.calcularComision(),0.0);
    }
}
