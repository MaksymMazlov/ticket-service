package mazlov.controller;

import mazlov.model.Baggage;
import mazlov.service.BaggageService;
import mazlov.service.CouponService;
import mazlov.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @Autowired
    private BaggageService baggageService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private TicketService ticketService;

    @PostMapping("/api/baggage")
    public boolean addToBaggage(@RequestBody Baggage baggage) {
        return baggageService.addBaggage(baggage);
    }

    @GetMapping("/api/coupon/{id}")
    public boolean checkCoupon(@PathVariable(name = "id") long id) {
        return couponService.checkCouponById(id);
    }

    @GetMapping("/api/tickets/{id}")
    public boolean checkTicket(@PathVariable(name = "id") long id) {
        return ticketService.checkTicketById(id);
    }
}
