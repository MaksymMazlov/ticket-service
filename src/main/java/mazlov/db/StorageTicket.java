package mazlov.db;

import mazlov.model.Ticket;

import java.util.HashSet;
import java.util.Set;

public class StorageTicket {
    private static final Set<Ticket> storageTicket = new HashSet<>();

    static {
        storageTicket.add(new Ticket(1L, 200));
        storageTicket.add(new Ticket(2L, 300));
        storageTicket.add(new Ticket(3L, 500));
        storageTicket.add(new Ticket(4L, 600));
        storageTicket.add(new Ticket(5L, 500));
        storageTicket.add(new Ticket(6L, 100));
        storageTicket.add(new Ticket(7L, 100));
        storageTicket.add(new Ticket(8L, 100));
        storageTicket.add(new Ticket(9L, 100));
        storageTicket.add(new Ticket(10L, 100));
    }

    public static Set<Ticket> all() {
        return storageTicket;
    }
}
