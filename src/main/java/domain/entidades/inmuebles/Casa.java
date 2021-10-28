package domain.entidades.inmuebles;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Casa extends Inmueble{
    private Double precio;

    @Override
    protected Double valorParticular() {
        return this.precio;
    }

}
