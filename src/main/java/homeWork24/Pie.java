package homeWork24;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pie extends Sweetness{
    private String topping;

    public Pie(String title, Integer weight, Integer price, String topping){
        super(title, weight, price);
        this.topping = topping;
    }

    @Override
    public String getUniqueParameter() {
        return "начинка: " + topping;
    }
}