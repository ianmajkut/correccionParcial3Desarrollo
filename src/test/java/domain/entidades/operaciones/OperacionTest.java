package domain.entidades.operaciones;

import domain.entidades.inmuebles.Casa;
import domain.entidades.inmuebles.Inmueble;
import domain.entidades.zonas.Zona;

public abstract class OperacionTest {
    protected Casa unaCasa;

    public void init(){
        Zona boedo = new Zona();
        boedo.setPrecio(6000.0);
        this.unaCasa = new Casa();
        this.unaCasa.setZona(boedo);
        this.unaCasa.setPrecio(54000.0);
    }
}
