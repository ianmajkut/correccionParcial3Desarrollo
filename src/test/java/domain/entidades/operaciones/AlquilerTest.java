package domain.entidades.operaciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerTest extends OperacionTest{

    @Before
    public void init() {
        super.init();
    }

    @Test

    public void alquilerDe3MesesDaComisionDe18Mil(){
        Alquiler.setFactorComision(0.1);
        Alquiler unAlquiler = new Alquiler();
        unAlquiler.setCantMeses(3);
        unAlquiler.setInmueble(super.unaCasa);

        Assert.assertEquals(18000.0, unAlquiler.calcularComision(),0.0);
    }
}
