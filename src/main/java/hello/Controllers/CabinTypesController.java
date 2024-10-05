package hello.Controllers;

import hello.Models.CabinTypes;
import hello.Models.Countries;
import hello.Repositories.CabinTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CabinTypesController {
    @Autowired
    private CabinTypesRepository cabinTypesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/cabintypes")
    public Iterable<CabinTypes> getCabinTypes() {
        return cabinTypesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/cabintypes/{id}")
    public Optional<CabinTypes> getCabinTypes(@PathVariable(value = "id") int id) {
        return cabinTypesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/cabintypes")
    public CabinTypes postCabinTypes(@RequestBody CabinTypes cabinTypes) {
        cabinTypesRepository.save(cabinTypes);
        return cabinTypes;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/cabintypes")
    public CabinTypes putCabinTypes(@RequestBody CabinTypes newCabinType) {
        try {
            CabinTypes cabinTypes = cabinTypesRepository.findById(newCabinType.getId()).orElseThrow();
            if (newCabinType.getName() != null) {
                cabinTypes.setName(newCabinType.getName());
            }
            cabinTypesRepository.save(cabinTypes);
            return cabinTypes;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/cabintypes/{id}")
    public CabinTypes deleteCabinTypes(@PathVariable(value = "id") int id) {
        try {
            CabinTypes cabinTypes = cabinTypesRepository.findById(id).orElseThrow();
            cabinTypesRepository.delete(cabinTypes);
            return cabinTypes;
        } catch (Exception e) {
            return null;
        }
    }
}
