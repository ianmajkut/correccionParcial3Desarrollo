package domain.entidades.personas;

import domain.entidades.operaciones.Operacion;
import domain.entidades.zonas.Zona;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Empleado {
    private String nombre;
    private String apellido;
    private List<Double> comisiones;
    private List<Operacion> operacionesCerrada;
    private List<Operacion> operacionesReservadas;

    public Empleado() {
        this.comisiones = new ArrayList<>();
        this.operacionesCerrada = new ArrayList<>();
        this.operacionesReservadas = new ArrayList<>();
    }


//    public void agregarComision(Double comision){
//        this.comisiones.add(comision);
//    }

    public void agregarComision(Double ... comisiones){
        Collections.addAll(this.comisiones, comisiones);
    }


    public void agregarOperacionCerrada(Operacion ... operaciones){
        Collections.addAll(this.operacionesCerrada, operaciones);
        //this.agregarComision(operaciones.calcularComision());
        for(Operacion unaOperacion: operaciones){
            this.agregarComision(unaOperacion.calcularComision());
        }
    }


//    public void agregarOperacionReservada(Operacion operacion){
//        this.operacionesReservadas.add(operacion);
//    }

    public void agregarOperacionReservada(Operacion ... operaciones){
        Collections.addAll(this.operacionesReservadas, operaciones);
    }

    public boolean podesTenerProblemaCon(Empleado otroEmpleado){
        return this.heCerradoOperacionesEnLaMismaZonaQue(otroEmpleado) &&
                this.algunoHaRobadoOperacion(otroEmpleado);
    }


    public boolean algunoHaRobadoOperacion(Empleado otroEmpleado){
        return this.operacionesReservadas.stream()
                .anyMatch(o -> otroEmpleado.operacionesCerrada.contains(o))
                ||
                this.operacionesCerrada.stream()
                    .anyMatch(o -> otroEmpleado.operacionesReservadas.contains(o));
    }

    private boolean heCerradoOperacionesEnLaMismaZonaQue(Empleado otroEmpleado){
        List<Zona> misZonas = this.zonasDeOperacionesCerradas();
        List<Zona> zonasDeOtros = otroEmpleado.zonasDeOperacionesCerradas();
        return misZonas.stream().anyMatch(z -> zonasDeOtros.contains(z)); // si algun elemento de mis zonas coincide con la zonas del otro
    }

    private List<Zona> zonasDeOperacionesCerradas(){
        return this.operacionesCerrada.stream().map(o -> o.getInmueble().getZona()).collect(Collectors.toList());
    }

    public Double totalDeComisiones(){
        return this.comisiones.stream().mapToDouble(c -> c.doubleValue()).sum();
    }

    public Integer cantOperacionesCerradas(){
        return this.operacionesCerrada.size();
    }

    public Integer cantOperacionesReservadas(){
        return this.operacionesReservadas.size();
    }

}
