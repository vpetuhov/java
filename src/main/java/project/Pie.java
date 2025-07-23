package project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pie extends Sweetness{
    private String title;
    private Integer weight;
    private Integer price;
    private String topping;

    @Override
    public String getUniqueParameter() {
        return "начинка: " + topping;
    }
}