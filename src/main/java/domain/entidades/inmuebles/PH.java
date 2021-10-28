package domain.entidades.inmuebles;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class PH extends Inmueble{

    private static Double valorM2;
    private static Double valorMinimo;


    @Override
    protected Double valorParticular() {
        Double valorSegunTamanio = super.getTamanioEnM2() * PH.valorM2;
        return valorSegunTamanio > valorMinimo? valorSegunTamanio : valorMinimo;
    }

    public static void setValorM2(Double valorM2) {
        PH.valorM2 = valorM2;
    }

    public static void setValorMinimo(Double valorMinimo) {
        PH.valorMinimo = valorMinimo;
    }

    public static Double getValorM2() {
        return valorM2;
    }

    public static Double getValorMinimo() {
        return valorMinimo;
    }

}
