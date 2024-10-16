package hello.Controllers;

import hello.Models.Amenities;
import hello.Models.AmenitiesCabinType;
import hello.Models.DTOs.AmenitiesCabinTypeDTO;
import hello.Repositories.AmenitiesCabinTypeRepository;
import hello.Repositories.AmenitiesRepository;
import hello.Repositories.CabinTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AmenitiesCabinTypeController {
    @Autowired
    private AmenitiesCabinTypeRepository amenitiesCabinTypeRepository;

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Autowired
    private CabinTypesRepository cabinTypesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenitiescabintypes")
    public Iterable<AmenitiesCabinType> getAmenities() {
        return amenitiesCabinTypeRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenitiescabintypes/{id}")
    public Optional<AmenitiesCabinType> getAmenities(@PathVariable(value = "id") int id) {
        return amenitiesCabinTypeRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/amenitiescabintypes")
    public AmenitiesCabinType postAmenities(@RequestBody AmenitiesCabinTypeDTO amenitiesCabinTypeDTO) {
        AmenitiesCabinType amenitiesCabinType = new AmenitiesCabinType();
        amenitiesCabinType.setAmenities(amenitiesRepository.findById(amenitiesCabinTypeDTO.getAmenities()).orElseThrow());
        amenitiesCabinType.setCabinType(cabinTypesRepository.findById(amenitiesCabinTypeDTO.getCabinType()).orElseThrow());
        amenitiesCabinTypeRepository.save(amenitiesCabinType);
        return amenitiesCabinType;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/amenitiescabintypes")
    public AmenitiesCabinType putAmenities(@RequestBody AmenitiesCabinTypeDTO amenitiesCabinTypeDTO) {
        try {
            AmenitiesCabinType amenitiesCabinType = new AmenitiesCabinType();
            if (amenitiesCabinTypeDTO.getAmenities() != null){
                amenitiesCabinType.setAmenities(amenitiesRepository.findById(amenitiesCabinTypeDTO.getAmenities()).orElseThrow());
            }
            if (amenitiesCabinTypeDTO.getCabinType() != null){
                amenitiesCabinType.setCabinType(cabinTypesRepository.findById(amenitiesCabinTypeDTO.getCabinType()).orElseThrow());
            }
            amenitiesCabinTypeRepository.save(amenitiesCabinType);
            return amenitiesCabinType;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/amenitiescabintypes/{id}")
    public AmenitiesCabinType deleteAmenities(@PathVariable(value = "id") int id) {
        try {
            AmenitiesCabinType amenitiesCabinType = amenitiesCabinTypeRepository.findById(id).orElseThrow();
            amenitiesCabinTypeRepository.delete(amenitiesCabinType);
            return amenitiesCabinType;
        } catch (Exception e) {
            return null;
        }
    }
}
