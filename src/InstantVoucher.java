
public class InstantVoucher extends Voucher {
    private int number;
    private double discount;

    public InstantVoucher(int number, int discount) {

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
