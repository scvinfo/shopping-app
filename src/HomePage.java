import java.util.Scanner;

public class HomePage {

    Cart cart = new Cart();
    private int ch = 0;

    public HomePage () {
        menu();
    }

    public void startScreen () {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");
    }

    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }

    public void menu () {
        do {
            startScreen();
            getUserInput();

            switch (ch) {
                case 1:
                    System.out.println("---------------------------");
                    displayStoreProducts();
                    System.out.println("---------------------------");
                    storeProductsMenu();
                    System.out.println("---------------------------");
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ch != 0);
    }

    private void innerChoice1() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:
                break;
        }
    }

    private int getUserInput() throws NumberFormatException {
        System.out.println("Enter your choice : ");
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    private void displayStoreProducts() {
        System.out.println("Store Products : ");
        Product[] products = new Products().getProducts();
        for (Product prod: products) {
            System.out.println(
                    prod.pid + "- " +
                            prod.name + " " +
                            prod.price + " " +
                            prod.stock
            );
        }
    }

    private void addProductToCart() {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter product ID: ");
        int pid = Integer.parseInt(in.nextLine());
        cart.addProductToCartByPID(pid);
    }

    private void showCart() {
        System.out.println("---------------------------");
        System.out.println("Cart Items : ");
        cart.printCartItems();
        System.out.println("---------------------------");
    }

    private void removeProductFromCart() {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter product ID to delete: ");
        int pid = Integer.parseInt(in.nextLine());
        cart.removeProductByPID(pid);
    }
}