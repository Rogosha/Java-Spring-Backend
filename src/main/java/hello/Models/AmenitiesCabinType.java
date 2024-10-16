package hello.Models;

import hello.Models.EmbeddedIds.AmenityCabinTypeId;
import jakarta.persistence.*;

@Entity
@Table(name="amenitiescabintype")
public class AmenitiesCabinType {

    @EmbeddedId
    private AmenityCabinTypeId id;

    @ManyToOne
    @MapsId("amenities")
    @JoinColumn(name = "AmenityID", nullable = false)
    private Amenities amenities;


    @ManyToOne
    @MapsId("cabinType")
    @JoinColumn(name = "CabintypeID", nullable = false)
    private CabinTypes cabinType;

    public AmenitiesCabinType(Amenities amenities, CabinTypes cabinType) {
        this.amenities = amenities;
        this.cabinType = cabinType;
    }

    public AmenitiesCabinType() {
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public CabinTypes getCabinType() {
        return cabinType;
    }

    public void setCabinType(CabinTypes cabinType) {
        this.cabinType = cabinType;
    }
}
