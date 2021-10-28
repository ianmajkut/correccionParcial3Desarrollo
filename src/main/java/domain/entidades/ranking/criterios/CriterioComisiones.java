package domain.entidades.ranking.criterios;

import domain.entidades.personas.Empleado;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CriterioComisiones implements CriterioRankeadorEmpleado{
    @Override
    public Empleado obtenerEmpleadoElegido(List<Empleado> empleados) {
        // Te devuelve el empleado que sea el que mas puntaje obtuvo despues de la primer coma (comparamos segun el total de comisiones)
        return Collections.max(empleados, Comparator.comparing(Empleado::totalDeComisiones));
    }
}
