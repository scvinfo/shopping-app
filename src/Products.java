public class Products {

    private final Product[] products = new Product[3];

    public Product[] getProducts() {
        initStoreItems();
        return products;
    }

    public void initStoreItems() {
        String [] productNames = {"Lux Soap", "Fair n Lovely", "MTR"};
        Double [] productPrice = {40.00d, 60.00d, 30.00d};
        Integer [] stock = {10, 6, 10};

        for (int i=0; i < productNames.length; i++) {
            Product product = new Product();
            product.name=productNames[i];
            product.pid=i+1;
            product.price=productPrice[i];
            product.stock=stock[i];
            products[i]=product;
        }
    }
}
