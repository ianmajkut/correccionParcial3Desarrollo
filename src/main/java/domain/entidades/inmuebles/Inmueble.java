package domain.entidades.inmuebles;

import domain.entidades.zonas.Zona;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Inmueble {
    protected Integer cantAmbientes;
    protected Double tamanioEnM2;
    private Zona zona;

    protected abstract Double valorParticular();

    public Double valor(){
        return this.zona.getPrecio() + this.valorParticular();
    }

}
