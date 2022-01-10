package mazlov.service;

import mazlov.db.StorageBaggage;
import mazlov.model.Baggage;
import org.springframework.stereotype.Service;


@Service
public class BaggageServiceImpl implements BaggageService {
    @Override
    public boolean addBaggage(Baggage baggage) {
        if (baggage.getBaggageId() <= 0) {
            throw new IllegalArgumentException("Wrong baggage ID");
        }

        if (baggage.getDestinationId() <= 0) {
            throw new IllegalArgumentException("Wrong baggage ID");
        }

        return StorageBaggage.add(baggage);
    }
}
