
public class DiscountVoucher extends Voucher {
    private int number;
    private double discount;

    public DiscountVoucher(int number, int discount, int credit) {
        super(credit);
        this.number = number;
        this.discount = discount;
    }

    /**
     * Override
     * @return
     */
    public double nextPrice() {
        double priceAfterCredit = super.nextPrice();
        if(number > 0) {
            double priceAfterDiscount = priceAfterCredit * discount * 0.01;
            number--;

            return priceAfterDiscount;
        }

        return priceAfterCredit;
    }
}
