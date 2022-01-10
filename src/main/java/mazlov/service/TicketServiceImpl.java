package mazlov.service;

import mazlov.db.StorageTicket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {
    private static final Logger logger = LogManager.getLogger(TicketServiceImpl.class);

    @Override
    public boolean checkTicketById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Wrong ticket ID");
        }

        logger.info("Method was called. Params: id = {}", id);
        return StorageTicket.all()
                .stream()
                .anyMatch(ticket -> ticket.getId().equals(id));
    }
}
