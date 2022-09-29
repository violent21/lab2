package ad211.dovbyshev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainStack();
        //mainQueue();
    }

    public static void mainStack() {
        Cart cart = new Cart(5);

        cart.newItem(new Item("carrot", 18));
        cart.newItem(new Item("banana", 12));
        cart.newItem(new Item("tomato", 25));
        cart.newItem(new Item("eggs", 35));
        cart.newItem(new Item("milk", 29));

        getList(cart);
        cart.sum();
        System.out.println(" ");

        cart.increasePrices(15);
        getList(cart);
        cart.sum();
        System.out.println(" ");

        cart.reducePrices(30);
        getList(cart);
        cart.sum();
        System.out.println(" ");

        int menu;
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.print("\n1. add new item\n2. remove last element\n3. get list of the cart\n4. exit\n");
            menu = scan.nextInt();

            switch(menu){
                case 1:
                    cart.newItem(new Item("apple", 15));
                    break;
                case 2:
                    cart.removeLastElement();
                    break;
                case 3:
                    getList(cart);
                    break;
                case 4:
                    System.out.print("\nClosing the program...");
                    System.exit(0);
                default:
                    System.out.print("\nNon-existent menu number\n");
            }
        }
    }

    public static void getList(Cart cart) {
        for (int i = 0; i < cart.getLastIndex(); i++){
            System.out.println(cart.getArray()[i].getName() + " - " + cart.getArray()[i].getPrice());
        }
    }

    public static void mainQueue() {
        CartQueue queue = new CartQueue(5);

        queue.add(new Item("water", 11));
        queue.add(new Item("bread", 22));
        queue.add(new Item("pepper", 17));
        queue.add(new Item("juice", 25));
        queue.add(new Item("salt", 33));

        getQueue(queue);
        queue.sum();
        System.out.println(" ");

        queue.increasePrices(15);
        getQueue(queue);
        queue.sum();
        System.out.println(" ");

        queue.reducePrices(30);
        getQueue(queue);
        queue.sum();
        System.out.println(" ");

        int menu;
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.print("\n1. add new item\n2. remove last element\n3. get list of the cart\n4. exit\n");
            menu = scan.nextInt();

            switch(menu){
                case 1:
                    queue.add(new Item("apple", 15));
                    break;
                case 2:
                    queue.remove();
                    break;
                case 3:
                    getQueue(queue);
                    queue.sum();
                    break;
                case 4:
                    System.out.print("\nClosing the program...");
                    System.exit(0);
                default:
                    System.out.print("\nNon-existent menu number\n");
            }
        }

    }

    public static void getQueue(CartQueue myQueue) {
        for (int i = 0; i < myQueue.getSize(); i++){
            System.out.println(myQueue.getQueue()[i].getName() + " - " + myQueue.getQueue()[i].getPrice());
        }
    }
}
