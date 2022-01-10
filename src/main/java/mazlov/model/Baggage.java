package mazlov.model;

import java.util.Objects;

public class Baggage {
    private int baggageId;
    private int destinationId;

    public Baggage(int baggageId, int destinationId) {
        this.baggageId = baggageId;
        this.destinationId = destinationId;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return baggageId == baggage.baggageId && destinationId == baggage.destinationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baggageId, destinationId);
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "baggageId=" + baggageId +
                ", destinationId=" + destinationId +
                '}';
    }
}
