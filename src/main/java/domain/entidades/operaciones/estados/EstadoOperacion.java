package domain.entidades.operaciones.estados;

import domain.entidades.operaciones.Operacion;
import domain.entidades.personas.Cliente;
import domain.entidades.personas.Empleado;

public interface EstadoOperacion {

    void concretar(Operacion operacion, Cliente cliente, Empleado empleado);
    void reservar(Operacion operacion, Cliente cliente, Empleado empleado);
}
