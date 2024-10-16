package hello.Models.DTOs;

public class AmenitiesCabinTypeDTO {
        private Integer amenities;

        private Integer cabinType;

    public AmenitiesCabinTypeDTO() {
    }

    public AmenitiesCabinTypeDTO(Integer amenities, Integer cabinType) {
        this.amenities = amenities;
        this.cabinType = cabinType;
    }

    public Integer getAmenities() {
        return amenities;
    }

    public void setAmenities(Integer amenities) {
        this.amenities = amenities;
    }

    public Integer getCabinType() {
        return cabinType;
    }

    public void setCabinType(Integer cabinType) {
        this.cabinType = cabinType;
    }
}
