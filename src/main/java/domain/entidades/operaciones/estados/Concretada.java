package domain.entidades.operaciones.estados;

import domain.entidades.operaciones.Operacion;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Concretada implements EstadoOperacion{
    private Cliente cliente;
    private Empleado empleado;

    public Concretada(Cliente cliente, Empleado empleado) {
        this.cliente = cliente;
        this.empleado = empleado;
    }

    @Override
    public void concretar(Operacion operacion, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No puede concretar esta operación porque ya esta concretada");
    }

    @Override
    public void reservar(Operacion operacion, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No puede reservar esta operación porque ya esta concretada");
    }

    
}
