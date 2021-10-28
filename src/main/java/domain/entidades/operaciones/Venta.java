package domain.entidades.operaciones;

public class Venta extends Operacion {
    private static Double porcentajeSobreInmueble;


    @Override
    public Double calcularComision() {
        return super.inmueble.valor() * Venta.porcentajeSobreInmueble;
    }

    public static void setPorcentajeSobreInmueble(Double porcentajeSobreInmueble) {
        Venta.porcentajeSobreInmueble = porcentajeSobreInmueble >= 1? porcentajeSobreInmueble / 100 : porcentajeSobreInmueble;
    }

    public static Double getPorcentajeSobreInmueble() {
        return porcentajeSobreInmueble;
    }
}
