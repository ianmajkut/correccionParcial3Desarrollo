package domain.entidades.empleado;

import domain.entidades.inmuebles.Casa;
import domain.entidades.operaciones.Operacion;
import domain.entidades.operaciones.Venta;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;
import domain.entidades.ranking.RankeadorEmpleado;
import domain.entidades.ranking.criterios.CriterioCantOperacionesCerradas;
import domain.entidades.ranking.criterios.CriterioCantOperacionesReservadas;
import domain.entidades.ranking.criterios.CriterioComisiones;
import domain.entidades.zonas.Zona;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmpleadoTest {

    private Operacion operacionMain, operacionLadron, operacion;


    //Empleado main concreto venta y el ladron quiere reservarla
    @Test
    public void empleadoConProblemaConOtroRobo(){
        Casa unaCasa = new Casa();
        unaCasa.setPrecio(550000.0);

        Zona boedo = new Zona();
        boedo.setNombre("Boedo");
        boedo.setPrecio(6000.0);
        unaCasa.setZona(boedo);

        Venta.setPorcentajeSobreInmueble(10.0);
//        this.operacionMain = new Venta();
//        this.operacionLadron = new Venta();
//
//        this.operacionMain.setInmueble(unaCasa);
//        this.operacionLadron.setInmueble(unaCasa);

        this.operacion = new Venta();
        this.operacion.setInmueble(unaCasa);

        Empleado empleadoMain = new Empleado();
        empleadoMain.setNombre("Sergio");
        empleadoMain.setApellido("Ramos");

        Empleado empleadoLadron = new Empleado();
        empleadoLadron.setNombre("Leo");
        empleadoLadron.setApellido("Ramos");

        Cliente cliente = new Cliente();
        cliente.setNombre("Diego");
        cliente.setApellido("Maradona");

//        this.operacionMain.concretar(cliente, empleadoMain);
//
//        this.operacionLadron.reservar(cliente, empleadoLadron);


        //empleadoMain.algunoHaRobadoOperacion(empleadoLadron);

        this.operacion.reservar(cliente,empleadoMain);

        this.operacion.concretar(cliente,empleadoLadron);


        Assert.assertEquals(true, empleadoMain.algunoHaRobadoOperacion(empleadoLadron));
    }


    @Test
    public void rankingComisionesTercerEmpleadoGanador(){
        Empleado primerEmpleado = new Empleado();
        Empleado segundoEmpleado = new Empleado();
        Empleado tercerEmpleado = new Empleado();

        RankeadorEmpleado rankeadorEmpleado = new RankeadorEmpleado();
        CriterioComisiones criterioComisiones = new CriterioComisiones();
        rankeadorEmpleado.setCriterio(criterioComisiones);

        rankeadorEmpleado.agregarEmpleados(primerEmpleado, segundoEmpleado, tercerEmpleado);

        primerEmpleado.agregarComision(0.1,0.2,0.3);
        segundoEmpleado.agregarComision(0.4,0.5,0.6);
        tercerEmpleado.agregarComision(0.7,0.8,0.9);

        primerEmpleado.setNombre("Sergio");
        primerEmpleado.setApellido("Ramos");


        segundoEmpleado.setNombre("Leo");
        segundoEmpleado.setApellido("MEssi");

        tercerEmpleado.setNombre("Diego");
        tercerEmpleado.setApellido("Maradona");

        Assert.assertEquals(tercerEmpleado, rankeadorEmpleado.obtenerEmpleadoElegido());
    }

    @Test
    public void rankingOperacionReservadasSegundoEmpleadoGana(){

        Empleado primerEmpleado = new Empleado();
        int operacionesPrimer = 5;
        Empleado segundoEmpleado = new Empleado();
        int operacionesSegundo = 6;
        Empleado tercerEmpleado = new Empleado();
        int operacionesTercero = 1;

        for (int i=0; i<operacionesPrimer; i++){
            Operacion operacion = new Venta();
            primerEmpleado.agregarOperacionReservada(operacion);
        }
        for (int i=0; i<operacionesSegundo; i++){
            Operacion operacion = new Venta();
            segundoEmpleado.agregarOperacionReservada(operacion);
        }
        for (int i=0; i<operacionesTercero; i++){
            Operacion operacion = new Venta();
            tercerEmpleado.agregarOperacionReservada(operacion);
        }


        RankeadorEmpleado rankeadorEmpleado = new RankeadorEmpleado();
        CriterioCantOperacionesReservadas criterioComisiones = new CriterioCantOperacionesReservadas();
        rankeadorEmpleado.setCriterio(criterioComisiones);

        rankeadorEmpleado.agregarEmpleados(primerEmpleado, segundoEmpleado, tercerEmpleado);

        primerEmpleado.setNombre("Sergio");
        primerEmpleado.setApellido("Ramos");


        segundoEmpleado.setNombre("LEo");
        segundoEmpleado.setApellido("MEssi");

        tercerEmpleado.setNombre("Diego");
        tercerEmpleado.setApellido("Maradona");

        Assert.assertEquals(segundoEmpleado, rankeadorEmpleado.obtenerEmpleadoElegido());


    }

    @Test
    public void rankingOperacionCerradas(){
        Empleado primerEmpleado = new Empleado();
        int operacionesPrimer = 2;
        Empleado segundoEmpleado = new Empleado();
        int operacionesSegundo = 1;
        Empleado tercerEmpleado = new Empleado();
        int operacionesTercero = 9;

        Casa unaCasa = new Casa();
        unaCasa.setPrecio(550000.0);

        Zona boedo = new Zona();
        boedo.setNombre("Boedo");
        boedo.setPrecio(6000.0);
        unaCasa.setZona(boedo);

        Venta.setPorcentajeSobreInmueble(10.0);

        for (int i=0; i<operacionesPrimer; i++){
            Operacion operacion = new Venta();
            operacion.setInmueble(unaCasa);
            primerEmpleado.agregarOperacionCerrada(operacion);
        }
        for (int i=0; i<operacionesSegundo; i++){
            Operacion operacion = new Venta();
            operacion.setInmueble(unaCasa);
            segundoEmpleado.agregarOperacionCerrada(operacion);
        }
        for (int i=0; i<operacionesTercero; i++){
            Operacion operacion = new Venta();
            operacion.setInmueble(unaCasa);
            tercerEmpleado.agregarOperacionCerrada(operacion);
        }

        RankeadorEmpleado rankeadorEmpleado = new RankeadorEmpleado();
        CriterioCantOperacionesCerradas criterioComisiones = new CriterioCantOperacionesCerradas();
        rankeadorEmpleado.setCriterio(criterioComisiones);

        rankeadorEmpleado.agregarEmpleados(primerEmpleado, segundoEmpleado, tercerEmpleado);

        primerEmpleado.setNombre("Sergio");
        primerEmpleado.setApellido("Ramos");


        segundoEmpleado.setNombre("Sergio");
        segundoEmpleado.setApellido("Ramos");

        tercerEmpleado.setNombre("Diego");
        tercerEmpleado.setApellido("Maradona");

        Assert.assertEquals(tercerEmpleado, rankeadorEmpleado.obtenerEmpleadoElegido());


    }
}
