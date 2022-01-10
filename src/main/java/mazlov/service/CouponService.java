package mazlov.service;

public interface CouponService {
    boolean checkCouponById(long Id);

    double getPriceByCouponId(long couponId, double price);
}
