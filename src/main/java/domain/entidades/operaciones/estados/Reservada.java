package domain.entidades.operaciones.estados;

import domain.entidades.operaciones.Operacion;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Reservada implements EstadoOperacion{
    private Cliente cliente;
    private Empleado empleado;

    public Reservada(Cliente cliente, Empleado empleado) {
        this.cliente = cliente;
        this.empleado = empleado;

    }

    @Override
    public void concretar(Operacion operacion, Cliente cliente, Empleado empleado) {
        if(!this.cliente.equals(cliente)){
            throw new RuntimeException("No puede concretar esta operación porque ya esta reservada por otro cliente");
        }
        operacion.setEstado(new Concretada(cliente, empleado));
        empleado.agregarOperacionCerrada(operacion);
    }

    @Override
    public void reservar(Operacion operacion, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede reservar porque ye está reservada");
    }
}
