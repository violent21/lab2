package ad211.dovbyshev;

public class Cart {
    private Item[] stack;
    private int lastIndex;

    public Cart (int amountOfElements) {
        stack = new Item[amountOfElements];
        lastIndex = 0;
    }

    public Item[] getArray(){
        return stack;
    }

    public int getLastIndex(){
        return lastIndex;
    }

    public void newItem(Item item){
        if (isArrayFull()) return;
        else push(item);
    }

    private void push(Item item){
        stack[lastIndex] = item;
        lastIndex++;
    }

    public void removeLastElement(){
        if (isArrayEmpty()) return;
        else pop();
    }

    private void pop(){
        lastIndex--;
    }

    private boolean isArrayFull(){
        boolean isFull = lastIndex == stack.length;
        if (isFull) System.out.println("Not enough space");
        return isFull;
    }

    private boolean isArrayEmpty(){
        boolean isEmpty = lastIndex == 0;
        if (isEmpty) System.out.println("No items");
        return isEmpty;
    }

    public void sum() {
        if (isArrayEmpty()) return;
        else getSum();
    }

    private void getSum() {
        float sum = 0;
        for (Item item : stack) sum += item.getPrice();
        System.out.println("\tTotal: " + sum);
    }

    public void increasePrices (float percent){
        doIncreasePrice(percent);
    }

    private void doIncreasePrice(float percent){
        for (int i = 0; i < lastIndex; i++) stack[i].increasePrice(percent);
    }

    public void reducePrices (float percent){
        doReducePrice(percent);
    }

    private void doReducePrice(float percent){
        for (int i = 0; i < lastIndex; i++) stack[i].reducePrice(percent);
    }
}
