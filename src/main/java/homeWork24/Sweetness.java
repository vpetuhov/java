package homeWork24;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Sweetness{
    public String title;
    public Integer weight;
    public Integer price;

    public Sweetness(String title, Integer weight, Integer price) {
        this.title = title;
        this.weight = weight;
        this.price = price;
    }

    public abstract String getUniqueParameter();
}