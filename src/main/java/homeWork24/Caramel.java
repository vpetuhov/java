package homeWork24;

import lombok.*;

@Getter
@Setter
@ToString
public class Caramel extends Sweetness{
    private String color;

    public Caramel(String title, Integer weight, Integer price, String color){
        super(title, weight, price);
        this.color = color;
    }

    @Override
    public String getUniqueParameter() {
        return "цвет " + color;
    }
}
