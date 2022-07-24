import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private float price;

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private static ArrayList<Product> products = new ArrayList<>();
    public static void showListOfProducts()
    {
        for (Product product:products) {
            System.out.println(product);
        }
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(int id, String name, float price,ArrayList<Product> products ) {
        this.id = id;
        this.name = name;
        this.price = price;
        setProducts(products);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public static void removeProduct(int productId)
    {
        products.remove(productId-1);
        for(int i = 0;i<Menu.getUsersWhoBoughtSmth().size();i++){
        if(Menu.getUsersWhoBoughtSmth().get(i).contains(products.get(productId-1)))
            Menu.getUsersWhoBoughtSmth().get(i).remove(productId-1);
    }
}
}
