package ad211.dovbyshev;

public class CartQueue {

    private Item[] queue;
    private int maxAmount;
    private int currentAmount;
    private int top;
    private int bottom;

    public CartQueue (int maxAmount) {
        this.maxAmount = maxAmount;
        queue = new Item[maxAmount];
        bottom = -1;
        top = 0;
        currentAmount = 0;
    }

    public int getSize() {
        return currentAmount;
    }

    public Item[] getQueue(){
        return queue;
    }

    public void add(Item item) {
        if(isQueueFull()) return;
        else{
            if (bottom == maxAmount - 1) {
                bottom = -1;
            }

            queue[++bottom] = item;
            currentAmount++;
        }
    }

    public Item remove() {
        Item firstElem = queue[top++];

        if (top == maxAmount) {
            top = 0;
        }
        currentAmount--;
        return firstElem;
    }

    public Item getFront() {
        return queue[top];
    }

    public Item getRear() {
        return queue[bottom];
    }

    public boolean isQueueFull() {
        boolean isFull = currentAmount == queue.length;
        if (isFull) System.out.println("Not enough space");
        return isFull;
    }

    public boolean isQueueEmpty() {
        boolean isEmpty = currentAmount == 0;
        if (isEmpty) System.out.println("No items");
        return isEmpty;
    }

    public void sum() {
        if (isQueueEmpty()) return;
        else getSum();
    }

    private void getSum() {
        float sum = 0;
        for (int i = 0; i < currentAmount; i++){
           sum += queue[i].getPrice();
        }
        System.out.println("\tTotal: " + sum);
    }

    public void increasePrices (float percent){
        doIncreasePrice(percent);
    }

    private void doIncreasePrice(float percent){
        for (int i = 0; i < currentAmount; i++) queue[i].increasePrice(percent);
    }

    public void reducePrices (float percent){
        doReducePrice(percent);
    }

    private void doReducePrice(float percent){
        for (int i = 0; i < currentAmount; i++) queue[i].reducePrice(percent);
    }
}
