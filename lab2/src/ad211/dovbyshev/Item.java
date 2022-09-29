package ad211.dovbyshev;

public class Item {

    String name;
    float price;

    public Item (String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public void increasePrice(float percent) {
        price += price * percent / 100;
    }

    public void reducePrice (float percent) {
        price -= price * percent / 100;
        checkIfNegative();
    }

    public void checkIfNegative() {
        if (price < 0) price = 0;
    }
}
