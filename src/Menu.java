import java.util.*;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static int userId =1;
    private static int productId =1;

    private static HashMap<User,ArrayList<Product>> usersWhoBoughtSmth= new HashMap<>();



    public static void main(String[] args) throws Exception {

        int option;
        while(true) {
            System.out.println(
                    "\n" +"**************************Menu**************************\n"
                            +"1.Show list of users\n"
                            + "2.Show list of products\n"
                            + "3.Buy a product\n"
                            + "4. Display list of user products by user id\n"
                            + "5. Display list of users that bought product by product id\n"
                            + "6. Add user\n"
                            + "7. Add product\n"
                            + "8. Remove user\n"
                            + "9. Remove product\n"
                            +"\nSelect an operation : "
                +"\n********************************************************");
            option=scanner.nextInt();
            switch (option) {
                case 1:
                    User.showListOfUsers();
                    break;
                case 2:
                    Product.showListOfProducts();
                    break;
                case 3:
                    buy();
                    break;
                case 4:
                    displayProductsByUserId();
                    break;
                case 5:
                    displayUsersByProductsId();
                    break;
                case 6:
                    users.add(addUser());
                    userId++;
                    break;
                case 7:
                    products.add(addProduct());
                    productId++;
                    break;
                case 8:
                    removeUser();
                    break;
                case 9:
                    removeProduct();
                    break;
            }

            System.out.println("");
        }
        }
    public static Product addProduct()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter price: ");
        float price = scanner.nextFloat();
        System.out.println("Enter name: ");
        String name = scanner.next();
        return new Product(productId,name,price,products);

    }
    public static HashMap<User, ArrayList<Product>> getUsersWhoBoughtSmth() {
        return usersWhoBoughtSmth;
    }
    private static void buy() throws Exception {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter user id: ");
        int userId= scanner.nextInt();
        System.out.println("Enter product id: ");
        int productId= scanner.nextInt();
        if(!User.buyProduct(userId,productId))
            throw new Exception("User has not enough money");
        else System.out.println("Purchase successful!");
        addUserWhoBought(userId,productId);
    }

private static void addUserWhoBought(int userId,int productId)
{
    if(!usersWhoBoughtSmth.containsKey(User.getUsers().get(userId-1)))
        usersWhoBoughtSmth.put(User.getUsers().get(userId-1),new ArrayList<>(List.of(Product.getProducts().get(productId-1))));
    else
        usersWhoBoughtSmth.get(User.getUsers().get(userId-1)).add(Product.getProducts().get(productId-1));
}
private static void displayProductsByUserId()
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter user id: ");
    int userId= scanner.nextInt();
    if(!usersWhoBoughtSmth.containsKey(User.getUsers().get(userId-1))
    ||usersWhoBoughtSmth.get(User.getUsers().get(userId-1)).isEmpty())
    return;
    else
        usersWhoBoughtSmth.get(User.getUsers().get(userId-1)).stream().forEach(System.out::println);
}
private  static void displayUsersByProductsId()
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter product id: ");
    int productId= scanner.nextInt();
    Product product= Product.getProducts().get(productId-1);
    for(int i = 0;i<usersWhoBoughtSmth.size();i++){
    if(usersWhoBoughtSmth.get(User.getUsers().get(i)).contains(product))
        System.out.print(User.getUsers().get(i)+", ");
        System.out.println();
}

}
    private static User addUser()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        System.out.println("Enter last name: ");
        String lastName = scanner.next();
        System.out.println("Enter amount of money: ");
        float amountOFmoney= scanner.nextFloat();
        return new User(userId,firstName,lastName,amountOFmoney,users);
    }

    private static void removeUser()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter user id: ");
        int userId=scanner.nextInt();
        User.removeUser(userId);
    }
private static void removeProduct()
{
    System.out.println("Enter product id: ");
    Scanner scanner= new Scanner(System.in);
    int productId=scanner.nextInt();
    Product.removeProduct(productId);
}
}
