package domain.entidades.ranking.criterios;

import domain.entidades.personas.Empleado;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CriterioCantOperacionesCerradas implements CriterioRankeadorEmpleado{

    @Override
    public Empleado obtenerEmpleadoElegido(List<Empleado> empleados) {
        return Collections.max(empleados, Comparator.comparing(Empleado::cantOperacionesCerradas));
    }
}
