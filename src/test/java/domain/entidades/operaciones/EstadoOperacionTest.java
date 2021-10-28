package domain.entidades.operaciones;

import domain.entidades.inmuebles.Casa;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;
import domain.entidades.zonas.Zona;
import org.junit.Before;
import org.junit.Test;

public class EstadoOperacionTest {
    private Casa casa;
    private Operacion operacion;
    //Defino una zona porque el Inmueble tiene una zona
    private Zona boedo;

    @Before
    public void init(){
        this.casa = new Casa();

        //Defino el precio
        this.casa.setPrecio(550000.0);
        //Defino el porcentaje que se cobra sobre las ventas
        Venta.setPorcentajeSobreInmueble(10.0);
        this.operacion  = new Venta();
        operacion.setInmueble(this.casa);


        this.boedo = new Zona();
        //Asignamos nobre y precio y le seteamos a la casa la zona
        this.boedo.setNombre("Boedo");
        this.boedo.setPrecio(6000.0);
        this.casa.setZona(boedo);


    }

    @Test(expected = RuntimeException.class) //aca ponemos que esperamos una excepción. El test pasa si recibimos una excepción
    public void casaReservadaNoSePuedeVolverAReservar(){
        this.operacion.reservar(new Cliente(), new Empleado()); //reservamos una vez
        this.operacion.reservar(new Cliente(), new Empleado()); //reservamos de vuelta con una nueva instancia de un cliente y empleado
    }

    @Test (expected = RuntimeException.class)
    public void casaConcretadaQueSeConcretaOtraVez(){
        //tener en cuenta que si no definimos la zona, el porcentaje de comision, el precio del inmueble, etc
        //nos tira null pointer exception
        this.operacion.concretar(new Cliente(), new Empleado());
        this.operacion.concretar(new Cliente(), new Empleado());
    }

    @Test (expected = RuntimeException.class)
    public void casaConcretadaQueSeReserva(){
        this.operacion.concretar(new Cliente(), new Empleado());
        this.operacion.reservar(new Cliente(), new Empleado());
    }

}
