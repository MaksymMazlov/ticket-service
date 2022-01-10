package mazlov.service;

import mazlov.db.StorageCoupon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    private static final Logger logger = LogManager.getLogger(CouponServiceImpl.class);

    private final CacheService cache;

    public CouponServiceImpl(CacheService cache) {
        this.cache = cache;
    }


    @Override
    public boolean checkCouponById(long id) {
        logger.info("Method was called. Params: id = {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("Wrong coupon ID");
        }

        logger.info("Try to get coupon from cache");

        String key = "checkCouponById" + id;
        Object val = cache.getFromCache(key);
        if (val == null) {
            logger.info("Data not found in cache, key {}", key);
            boolean result = StorageCoupon.all()
                    .stream().
                    anyMatch(coupon -> coupon.getId().equals(id));

            logger.info("add data to cache, key {}", key);
            cache.addToCache(key, val);
            return result;
        } else {
            logger.info("Data found in cache, key {}", key);
            return (boolean) val;
        }

    }

    @Override
    public double getPriceByCouponId(long couponId, double price) {

        if (checkCouponById(couponId)) {
            return price * getDiscount();
        }
        logger.error("Can`t found couponId", couponId);
        throw new RuntimeException("Can`t found couponId =  " + couponId);
    }

    private Integer getDiscount() {
        List<Integer> discounts = new ArrayList<>();
        discounts.add(10);
        discounts.add(50);
        discounts.add(60);
        Collections.shuffle(discounts);
        return discounts.stream().findAny().get();
    }
}
