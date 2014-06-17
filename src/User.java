import java.util.ArrayList;

public class User {
    private Voucher voucher;
    private ArrayList<Order> orders;

    /**
     * Default constructor for a user without a voucher
     */
    public User() {
        voucher = new Voucher(0);
        orders = new ArrayList<Order>();
    }

    /**
     * Constructor for a user with a voucher
     * @param voucher
     */
    public User(Voucher voucher) {
        this.voucher = voucher;
        orders = new ArrayList<Order>();
    }


    /**
     * Bill user for a new order.
     */
    public void bill(){
        Order newOrder = new Order(voucher);
        orders.add(newOrder);
    }

    /*
     * @return the order at orderIndex
     */
    public Order getOrder(int orderIndex) {
        return orders.get(orderIndex);
    }
}
