package domain.entidades.operaciones.estados;

import domain.entidades.operaciones.Operacion;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;

public class Publicada implements EstadoOperacion{

    @Override
    public void concretar(Operacion operacion, Cliente cliente, Empleado empleado) {
        operacion.setEstado(new Concretada(cliente, empleado));
        empleado.agregarOperacionCerrada(operacion);
    }

    @Override
    public void reservar(Operacion operacion, Cliente cliente, Empleado empleado) {
        operacion.setEstado(new Reservada(cliente, empleado));
        empleado.agregarOperacionReservada(operacion);
    }
}
