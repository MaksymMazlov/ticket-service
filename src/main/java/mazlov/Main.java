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

public class Main {
    public static void main(String[] args) {
        TicketService ticketService = new TicketServiceImpl();
        CacheServiceImpl cache = new CacheServiceImpl();
        CouponService couponService = new CouponServiceImpl(cache);
        BaggageService baggageService = new BaggageServiceImpl();

        System.out.println(ticketService.checkTicketById(2L));
        System.out.println();
        System.out.println(StorageCoupon.all());
        System.out.println(StorageTicket.all());
        System.out.println(couponService.getPriceByCouponId(57, 100));

        baggageService.addBaggage(new Baggage(1, 1));
        baggageService.addBaggage(new Baggage(2, 2));
        System.out.println(baggageService.addBaggage(new Baggage(2, 2)));
    }
}
