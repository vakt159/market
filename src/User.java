import java.util.ArrayList;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private float amountOfMoney;
    private static ArrayList <User> users = new ArrayList<>();
    public User(int id, String firstName, String lastName, float amountOfMoney,ArrayList<User> users) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        setUsers(users);
    }
    public static void removeUser(int userId)
    {
        users.remove(userId-1);
    }
    public static void showListOfUsers()
    {
        for (User user : users) {
            System.out.println(user);

        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public static boolean buyProduct(int userId, int productId)
    {
        if(getUsers().get(userId-1).getAmountOfMoney()>Product.getProducts().get(productId-1).getPrice())
        {
            getUsers().get(userId-1).setAmountOfMoney(getUsers().get(userId-1).getAmountOfMoney()-Product.getProducts().get(productId-1).getPrice());
            return true;
        }
        return false;



    }
}
