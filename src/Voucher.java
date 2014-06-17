
public class Voucher {
    private double credit;
    private static double DEFAULT_PRICE = 6.95;


    public Voucher(int credit) {
        this.credit = credit;
    }

    /**
     * Given the current state of the voucher, update the voucher and
     * return the price of the next order.
     * @return the price of the next order.
     */
    public double nextPrice() {
        if(credit > DEFAULT_PRICE) {
            credit -= DEFAULT_PRICE;
            return 0;
        }

        else {
            double nextPrice = DEFAULT_PRICE - credit;
            credit = 0;
            return nextPrice;
        }

    }

    public double getCredit() {
        return credit;
    }

}
