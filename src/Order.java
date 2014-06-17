
public class Order {
    private double price;

    public Order(Voucher voucher) {
        price = voucher.nextPrice();
    }

    /**
     * Access the price the user paid for the order
     * @return price
     */
    public double billedFor() {
        return price;
    }


}
