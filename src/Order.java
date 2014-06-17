
public class Order {
    private static double DEFAULT_PRICE = 6.95;
    private double price;


    public Order() {
        price = DEFAULT_PRICE;
    }

    /**
     * Access the price the user paid for the order
     * @return price
     */
    public double billedFor() {
        return price;
    }

    /**
     * Calculate and set the price the user will pay, based on their
     * voucher
     * @param voucher
     */
    public void setPrice(Voucher voucher) {

    }

}
