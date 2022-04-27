package MyStream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MyCollector {

    public static void main(String[] args) {

        Cart cart = new Cart();
        cart.add(new Product(Long.valueOf(2684), "Cucumber", new BigDecimal(125.5f)), 1);
        cart.add(new Product(Long.valueOf(89743), "Milk", new BigDecimal(89.8f)), 2);
        cart.add(new Product(Long.valueOf(86741), "Cake", new BigDecimal(358.7f)));
        cart.add(new Product(Long.valueOf(981), "Water", new BigDecimal(39.87f)), 2);
        cart.add(new Product(Long.valueOf(2684), "Plate", new BigDecimal(15.5f)), 6);

        var rows = cart.getProducts().entrySet().stream()
                .map((e) -> {
                    return new cartRow(e);
                })
                .collect(Collectors.toList());
        var price = cart.getProducts().entrySet().stream()
                        .map((e) -> {
                            cartRow newCartRow = new cartRow(e);
                            return newCartRow.getRowPrice();
                        })
                        .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));



        System.out.println(rows);
    }



}

record cartRow(Product product, int quantity){

    public cartRow(Map.Entry<Product, Integer> e){
        this(e.getKey(), e.getValue());
    }

    public BigDecimal getRowPrice(){
        BigDecimal price = product.getPrice().multiply(new BigDecimal(quantity));
        return price;
    }
}

class Product{
    private final Long id;
    private final String label;
    private final BigDecimal price;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getPrice() {
        return price;
    }



    public Product(Long id, String label, BigDecimal price){
        this.id = id;
        this.label = label;
        this.price = price;
    }
}

class Cart{

    private final Map<Product, Integer> products = new HashMap<>();

    public void add(Product prod){
        add(prod, 1);
    }

    public void add(Product prod, int quantity){
        products.merge(prod,
                quantity,
                (a, b) -> Integer.sum(a,b));
    }

    public void remove(Product prod){
        products.remove(prod);
    }

    public void setQuantity(Product prod, int quantity){
        products.put(prod, quantity);
    }

    public Map<Product, Integer> getProducts(){
        return Collections.unmodifiableMap(products);
    }

}

class PriceAndRows{

    private BigDecimal price;
    private final List<cartRow> rows = new ArrayList<>();

    public PriceAndRows(BigDecimal price, List<cartRow> cartRows){
        this.price = price;
        this.rows.addAll(cartRows);
    }

    public PriceAndRows(){
        this(BigDecimal.ZERO, new ArrayList<>());
    }

}


