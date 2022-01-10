package mazlov.db;

import mazlov.model.Coupon;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StorageCoupon {
    private static final Set<Coupon> storageCoupon = new HashSet<>();

    static {
        storageCoupon.add(new Coupon((long) new Random().nextInt(100)));
        storageCoupon.add(new Coupon((long) new Random().nextInt(100)));
        storageCoupon.add(new Coupon((long) new Random().nextInt(100)));
        storageCoupon.add(new Coupon(57L));
    }

    public static boolean add(Coupon coupon) {
        return storageCoupon.add(coupon);
    }

    public static Set<Coupon> all() {
        return storageCoupon;
    }
}
