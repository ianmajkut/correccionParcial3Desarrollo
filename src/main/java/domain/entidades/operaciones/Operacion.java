package domain.entidades.operaciones;

import domain.entidades.inmuebles.Inmueble;
import domain.entidades.operaciones.estados.EstadoOperacion;
import domain.entidades.operaciones.estados.Publicada;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public abstract class Operacion {

    protected Inmueble inmueble;
    private EstadoOperacion estado;

    public Operacion(){
        this.estado = new Publicada(); //inicializamos como estado inicial publicada porque es asi como inicia el estado
    }

    public abstract Double calcularComision();

    public void reservar(Cliente cliente, Empleado empleado){
        this.estado.reservar(this, cliente,empleado); //this porque es esta Operacion la que le pasamos
    }

    public void concretar(Cliente cliente, Empleado empleado){
        this.estado.concretar(this, cliente,empleado); //this porque es esta Operacion la que le pasamos
    }
}
