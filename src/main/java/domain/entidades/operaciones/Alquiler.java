package domain.entidades.operaciones;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Alquiler extends Operacion{
    private Integer cantMeses;
    private static Double factorComision;


    @Override
    public Double calcularComision() {
        return (this.cantMeses * super.inmueble.valor()) * Alquiler.factorComision;
    }

    public static void setFactorComision(Double factorComision) {
        Alquiler.factorComision = factorComision;
    }

}


