package hello.Models.EmbeddedIds;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AmenityCabinTypeId implements Serializable {

    private Integer cabinType;
    private Integer amenities;

    public AmenityCabinTypeId(Integer cabinTypeId, Integer amenityId) {
        this.cabinType = cabinTypeId;
        this.amenities = amenityId;
    }

    public AmenityCabinTypeId() {
    }

    public Integer getCabinType() {
        return cabinType;
    }

    public void setCabinType(Integer cabinType) {
        this.cabinType = cabinType;
    }

    public Integer getAmenityId() {
        return amenities;
    }

    public void setAmenityId(Integer amenityId) {
        this.amenities = amenityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenities, cabinType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AmenityCabinTypeId objClass = (AmenityCabinTypeId) obj;
        return  Objects.equals(cabinType, objClass.getCabinType()) &&
                Objects.equals(amenities, objClass.getAmenityId());
    }
}
