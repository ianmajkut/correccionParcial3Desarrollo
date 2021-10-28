package domain.entidades.inmuebles;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Departamento extends Inmueble {
    private static Double valorPorAmbiente;

    @Override
    protected Double valorParticular() {
        return super.getCantAmbientes() * Departamento.valorPorAmbiente;
    }

    public static void setValorPorAmbiente(Double valorPorAmbiente) {
        Departamento.valorPorAmbiente = valorPorAmbiente;
    }
}
