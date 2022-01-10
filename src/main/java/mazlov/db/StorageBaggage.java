package mazlov.db;

import mazlov.model.Baggage;

import java.util.HashSet;
import java.util.Set;

public class StorageBaggage {
    private static final Set<Baggage> storageBaggage = new HashSet<>();

    public static boolean add(Baggage baggage) {
        return storageBaggage.add(baggage);
    }
}
