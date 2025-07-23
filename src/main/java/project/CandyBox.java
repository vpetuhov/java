package project;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CandyBox implements СandyBoxManagement{
    private List<Sweetness> sweetnessList = new ArrayList<Sweetness>();

    @Override
    public void addSweetness(Sweetness sweetness) {
        sweetnessList.add(sweetness);
    }
    @Override
    public void deleteSweetness(Integer index) {
        sweetnessList.remove(sweetnessList.get(index));
    }
    @Override
    public Integer getWeightBox() {
        int weightBox = 0;
        for(Sweetness sweetness : sweetnessList){
            weightBox += sweetness.getWeight();
        }
        return weightBox;
    }
    @Override
    public Integer getPriceBox() {
        int priceBox = 0;
        for(Sweetness sweetness : sweetnessList){
            priceBox += sweetness.getPrice();
        }
        return priceBox;
    }
    @Override
    public void getInfoAboutBox() {
        for(Sweetness sweetness : sweetnessList){
            System.out.println(String.format("Название: %s, вес: %d, цена: %d, %s",
                    sweetness.getTitle(), sweetness.getWeight(), sweetness.getPrice(), sweetness.getUniqueParameter()));
        }
    }

    public void removeSweetWithMinWeight(int requiredWeight){
        sweetnessList = sweetnessList.stream().sorted((s1, s2)-> Integer.compare(s1.getWeight(), s2.getWeight())).collect(Collectors.toList());
        Integer currentWeightBox = sweetnessList.stream().mapToInt(Sweetness::getWeight).sum();
        Integer maxWeightSweet = sweetnessList.stream().mapToInt(Sweetness::getWeight).max().orElseThrow(() -> new IllegalStateException("Список пуст"));
        for (int i = 0; i < sweetnessList.size(); i++) {
            if (requiredWeight < maxWeightSweet){
                System.out.println("Удаление невозможно, нет сладости подходящего веса.");
                break;
            } else if (requiredWeight > currentWeightBox) {
                System.out.println("Удаление не требуется, вес коробки удовлетворят требованию.");
                break;
            } else if (currentWeightBox > requiredWeight) {
                currentWeightBox -= sweetnessList.get(i).getWeight();
                sweetnessList.remove(0);
            }
        }
    }

    public void removeSweetWithMinPrice(int requiredWeight){
        sweetnessList = sweetnessList.stream().sorted((s1, s2)-> Integer.compare(s1.getPrice(), s2.getPrice())).collect(Collectors.toList());
        Integer currentWeightBox = sweetnessList.stream().mapToInt(Sweetness::getWeight).sum();
        Integer maxWeightSweet = sweetnessList.stream().mapToInt(Sweetness::getWeight).max().orElseThrow(() -> new IllegalStateException("Список пуст"));
        for (int i = 0; i < sweetnessList.size(); i++) {
            if (requiredWeight < maxWeightSweet){
                System.out.println("Удаление невозможно, нет сладости подходящего веса.");
                break;
            } else if (requiredWeight > currentWeightBox) {
                break;
            } else if (currentWeightBox > requiredWeight) {
                currentWeightBox -= sweetnessList.get(i).getWeight();
                sweetnessList.remove(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CandyBox candyBox = new CandyBox();
        Honey honey  = new Honey("Honey", 100, 900, "Normal");
        Pie pie = new Pie("Pie", 500, 600, "Strawberry");
        Caramel caramel = new Caramel("Caramel", 700, 400, "Red");

        candyBox.addSweetness(honey);
        candyBox.addSweetness(pie);
        candyBox.addSweetness(caramel);

        System.out.println(String.format("Общий вес подарка %d грамм", candyBox.getWeightBox()));
        System.out.println(String.format("Общая стоимость подарка %d рублей", candyBox.getPriceBox()));
        for(Sweetness sweetness : candyBox.sweetnessList){
            System.out.println(String.format("Название: %s, вес: %d, цена: %d, %s",
                    sweetness.getTitle(), sweetness.getWeight(), sweetness.getPrice(), sweetness.getUniqueParameter()));
        }

        System.out.print("Введите '1' для оптимизации подарка по весу или '2' для оптимизации по цене: ");
        int requiredType = scanner.nextInt();
        System.out.print("Введите максимальный вес коробки: ");
        int requiredVolume = scanner.nextInt();

        if (requiredType == 1) {candyBox.removeSweetWithMinWeight(requiredVolume);}
        else {candyBox.removeSweetWithMinPrice(requiredVolume);}

        System.out.println(String.format("Вес подарка после оптимизации: %d грамм", candyBox.getWeightBox()));
        System.out.println(String.format("Цена подарка после оптимизации: %d рублей", candyBox.getPriceBox()));
    }
}