package domain.entidades.ranking;

import domain.entidades.personas.Empleado;
import domain.entidades.ranking.criterios.CriterioRankeadorEmpleado;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class RankeadorEmpleado {
    private List<Empleado> empleados;
    private CriterioRankeadorEmpleado criterio;

    public RankeadorEmpleado() {
        this.empleados = new ArrayList<>();
    }

    public Empleado obtenerEmpleadoElegido(){
        return this.criterio.obtenerEmpleadoElegido(this.empleados);
    }
    
    public void agregarEmpleados(Empleado ... empleados){
        Collections.addAll(this.empleados, empleados);
    }
}
