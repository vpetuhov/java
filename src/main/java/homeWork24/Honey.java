package homeWork24;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Honey extends Sweetness{
    private String viscosity;

    public Honey(String title, Integer weight, Integer price, String viscosity){
        super(title, weight, price);
        this.viscosity = viscosity;
    }

    @Override
    public String getUniqueParameter() {
        return "вязкость: " + viscosity;
    }
}