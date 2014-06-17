
public class InstantVoucher extends Voucher {
    private int number;
    private double discount;

    public InstantVoucher(int number, int discount, int credit) {
        super(credit);
        this.number = number;
        this.discount = discount;
    }

    /**
     * Override.
     *
     * @return
     */
    public double nextPrice() {
        return 0;
    }
}
