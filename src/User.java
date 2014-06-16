import java.util.ArrayList;

public class User {
    private Voucher voucher;
    private ArrayList<Order> orders;

    /**
     * Default constructor for a user without a voucher
     */
    public User() {

    }

    /**
     * Constructor for a user with a voucher
     * @param voucher
     */
    public User(Voucher voucher) {

    }


    /**
     * Bill user for a new order.
     */
    public void bill(){

    }

    /*
     * @return the order at orderIndex
     */
    public Order getOrder(int orderIndex) {
        return orders.get(orderIndex);
    }
}
