package domain.entidades.ranking.criterios;

import domain.entidades.personas.Empleado;

import java.util.List;

public interface CriterioRankeadorEmpleado {

    Empleado obtenerEmpleadoElegido(List<Empleado> empleados);
}
