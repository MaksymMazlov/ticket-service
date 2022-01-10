package mazlov;

import mazlov.db.StorageCoupon;
import mazlov.db.StorageTicket;
import mazlov.model.Baggage;
import mazlov.service.BaggageService;
import mazlov.service.BaggageServiceImpl;
import mazlov.service.CacheServiceImpl;
import mazlov.service.CouponService;
import mazlov.service.CouponServiceImpl;
import mazlov.service.TicketService;
import mazlov.service.TicketServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TicketService ticketService = new TicketServiceImpl();
        CacheServiceImpl cache = new CacheServiceImpl();
        CouponService couponService = new CouponServiceImpl(cache);
        BaggageService baggageService = new BaggageServiceImpl();


        log.info("--------- Tickets test --------");
        log.info(StorageTicket.all());
        log.info(ticketService.checkTicketById(2L));


        log.info("--------- Coupon test --------");
        log.info(StorageCoupon.all());
        log.info(couponService.getPriceByCouponId(57, 100));


        log.info("--------- Baggage test --------");
        Baggage baggage = new Baggage(1, 1);
        log.info("Adding baggage: {}, result: {}", baggage, baggageService.addBaggage(baggage));

        baggage = new Baggage(2, 2);
        log.info("Adding baggage: {}, result: {}", baggage, baggageService.addBaggage(baggage));

        baggage = new Baggage(2, 2);
        log.info("Adding baggage: {}, result: {}", baggage, baggageService.addBaggage(baggage));
    }
}
