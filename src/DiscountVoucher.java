
public class DiscountVoucher extends Voucher {
    private int number;
    private double discount;

    public DiscountVoucher(int number, int discount) {

    }

    /**
     * Override
     * @return
     */
    public double nextPrice() {
        return 0;
    }
}
