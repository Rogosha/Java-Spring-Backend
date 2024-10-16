package hello.Models.EmbeddedIds;

import java.util.Objects;

public class AmenityTicketsId {

    private Integer ticketsId;
    private Integer amenityId;

    public AmenityTicketsId(Integer cabinTypeId, Integer amenityId) {
        this.ticketsId = cabinTypeId;
        this.amenityId = amenityId;
    }

    public AmenityTicketsId() {
    }

    public Integer getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(Integer ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Integer getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Integer amenityId) {
        this.amenityId = amenityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenityId, ticketsId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AmenityTicketsId objClass = (AmenityTicketsId) obj;
        return  Objects.equals(ticketsId, objClass.getTicketsId()) &&
                Objects.equals(amenityId, objClass.getAmenityId());
    }
}
