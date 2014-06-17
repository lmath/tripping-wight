/**
 * An instant voucher is one where the user pays up front for a fixed
 * number of orders (possibly at a discount) and then the user is billed
 * 0 for the orders that have been prepaid.
 */
public class InstantVoucher extends Voucher {
    private boolean isPaid;
    private int number;
    private double discount;

    public InstantVoucher(int number, int discount, int credit) {
        super(credit);
        this.isPaid = false;
        this.number = number;
        this.discount = discount;
    }

    /**
     * Override.
     *
     * @return
     */

    public double nextPrice() {
        double priceAfterCredit = super.nextPrice();
        if(number > 0) {
            if (isPaid) {
                number--;
                return 0;
            } else {
                double priceAfterCreditAndDiscount = priceAfterCredit * discount * 0.01;
                double upfrontPrice = priceAfterCreditAndDiscount * number;
                isPaid = true;
                number--;
                return upfrontPrice;
            }
        }
        return priceAfterCredit;

    }
}
