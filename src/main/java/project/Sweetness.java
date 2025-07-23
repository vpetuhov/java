package project;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Sweetness{
    public String title;
    public Integer weight;
    public Integer price;

    public abstract String getUniqueParameter();
}