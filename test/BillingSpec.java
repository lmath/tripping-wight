import junit.framework.TestCase;

public class BillingSpec extends TestCase{

    /*
     * A user, by default, should have no voucher and be charged 6.95 when billed.
     */
    public final void testBillGivesDefaultWhenNoVoucher() {
        User noVoucherUser = new User();

        noVoucherUser.bill();
        assertEquals(noVoucherUser.getOrder(0).billedFor(), 6.95);
        noVoucherUser.bill();
        assertEquals(noVoucherUser.getOrder(1).billedFor(), 6.95);
        noVoucherUser.bill();
        assertEquals(noVoucherUser.getOrder(2).billedFor(), 6.95);
    }

    /*
     * A user with a credit should have credit applied to the bill
     * until the credit hits zero.
     */
    public final void testBillAppliesAvailableCredit() {
        Voucher creditVoucher = new Voucher(15);
        User creditUser = new User(creditVoucher);

        creditUser.bill();
        assertEquals(creditUser.getOrder(0).billedFor(), 0.0);
        creditUser.bill();
        assertEquals(creditUser.getOrder(1).billedFor(), 0.0);
        creditUser.bill();
        assertEquals(creditUser.getOrder(2).billedFor(), 5.85);

    }

    /*
     * A user with a discount voucher should have the specified
     * percentage discount applied when billed, for a fixed
     * number of orders.
     */
    public final void testBillAppliesDiscountVoucher(){
        Voucher discountVoucher = new DiscountVoucher(3, 50, 0);
        User discountUser = new User(discountVoucher);

        discountUser.bill();
        assertEquals(discountUser.getOrder(0).billedFor(), 3.475);
        discountUser.bill();
        assertEquals(discountUser.getOrder(1).billedFor(), 3.475);
        discountUser.bill();
        assertEquals(discountUser.getOrder(2).billedFor(), 3.475);
        discountUser.bill();
        assertEquals(discountUser.getOrder(3).billedFor(), 6.95);
    }

    /**
     * A user with an instant voucher should pay for a fixed number
     * of orders upfront, possibly at a discount. The following orders
     * up to that fixed number are billed at zero.
     */
    public final void testBillPaysWithFirstOrderIfInstantVoucher() {
        Voucher instantVoucher = new InstantVoucher(50, 3, 0);
        User instantUser = new User(instantVoucher);

        instantUser.bill();
        assertEquals(instantUser.getOrder(0).billedFor(), 10.425);
        instantUser.bill();
        assertEquals(instantUser.getOrder(1).billedFor(), 0.0);
        instantUser.bill();
        assertEquals(instantUser.getOrder(2).billedFor(), 0.0);
        instantUser.bill();
        assertEquals(instantUser.getOrder(3).billedFor(), 6.95);

    }

}
