import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Cart {
        Product[] cartItems = new Product[]{};

        public void addProductToCartByPID(int pid) {
            Product product = getProductByProductID(pid);
            addToCart(product);
        }

        private Product getProductByProductID(int pid) {
            Product product = null;
            Product[] products = new Products().getProducts();
            for (Product prod: products) {
                if (prod.pid == pid) {
                    product = prod;
                    break;
                }
            }
            return product;
        }

        private void addToCart(Product product) {
            Product[] toAdd = new Product[cartItems.length+1];
            if(cartItems.length==0)
            {
                toAdd[0]=product;
            }
            else {
                for (int i = 0; i < cartItems.length; i++) {
                    toAdd[i] = cartItems[i];
                }
                toAdd[cartItems.length]=product;
            }
            cartItems = toAdd;
        }

        public void removeProductByPID(int pid) {
            for(int i=0;i<cartItems.length;i++){
                if(cartItems[i].pid ==pid)
                {
                    cartItems = ArrayUtils.remove(cartItems,i);
                }
            }
        }

        void printCartItems() {
            for (Product prod: cartItems) {
                System.out.println(prod.name);
            }
        }
}
