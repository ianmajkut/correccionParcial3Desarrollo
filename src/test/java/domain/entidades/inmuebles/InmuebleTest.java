package domain.entidades.inmuebles;

import domain.entidades.zonas.Zona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InmuebleTest {
    private Zona boedo;

    @Before
    public void init() {
        this.boedo = new Zona();
        this.boedo.setNombre("Boedo");
        this.boedo.setPrecio(6000.0);

    }

    @Test
    public void casaVale60Mil(){
        Casa unaCasa = new Casa();
        unaCasa.setZona(this.boedo);
        unaCasa.setCantAmbientes(2);
        unaCasa.setTamanioEnM2(155.0);
        unaCasa.setPrecio(54000.00);

        Assert.assertEquals(60000.00, unaCasa.valor(),0.0);

    }

    @Test
    public void phVale60Mil(){
        PH.setValorM2(1000.0);
        PH.setValorMinimo(30000.0);
        PH unPh = new PH();
        unPh.setZona(this.boedo);
        unPh.setTamanioEnM2(54.0);

        Assert.assertEquals(60000.0, unPh.valor(), 0.0);

    }

    @Test
    public void phSuperaValorMin (){
        PH.setValorM2(11000.0);
        PH.setValorMinimo(500000.0);
        PH unPh = new PH();
        unPh.setZona(this.boedo);
        unPh.setTamanioEnM2(50.0);


        Double calculoValorPh = unPh.getTamanioEnM2() * PH.getValorM2();
        Double precioEsperado;

        if(calculoValorPh > PH.getValorMinimo()){
            precioEsperado = calculoValorPh;
        }else{
            precioEsperado = PH.getValorMinimo();
        }
        //El precio esperado es de 550.000 así que ese va a ser el valor
        //System.out.println(precioEsperado);

        Assert.assertEquals(precioEsperado, unPh.valorParticular(),0.0);

    }

    @Test
    public void departamentoVale60Mil(){
        Departamento.setValorPorAmbiente(27000.00);
        Departamento unDepto = new Departamento();
        unDepto.setZona(this.boedo);
        unDepto.setCantAmbientes(2);

        Assert.assertEquals(60000.0, unDepto.valor(), 0.0);

    }

}
