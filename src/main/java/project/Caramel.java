package project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Caramel extends Sweetness{
    private String title;
    private Integer weight;
    private Integer price;
    private String color;

    @Override
    public String getUniqueParameter() {
        return "цвет " + color;
    }
}
