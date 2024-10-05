package hello.Controllers;

import hello.Models.Routes;
import hello.Models.RoutesDTO;
import hello.Repositories.AirportsRepository;
import hello.Repositories.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoutesController {
    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private AirportsRepository airportsRepository;


    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/routes")
    public Iterable<Routes> getRoute() {
        return routesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/routes/{id}")
    public Optional<Routes> getRoute(@PathVariable(value = "id") int id) {
        return routesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PostMapping("/routes")
    public Routes postRoute(@RequestBody RoutesDTO routesDTO) {
        Routes route = new Routes();
        route.setDepartureAirport(airportsRepository.findById(routesDTO.getDepartureAirport()).orElseThrow());
        route.setArrivalAirport(airportsRepository.findById(routesDTO.getArrivalAirport()).orElseThrow());
        route.setDistance(routesDTO.getDistance());
        route.setFlightTime(routesDTO.getFlightTime());
        routesRepository.save(route);
        return route;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PutMapping("/routes")
    public Routes putRoute(@RequestBody RoutesDTO routeDTO) {
        try {
            Routes route = routesRepository.findById(routeDTO.getId()).orElseThrow();
            if (routeDTO.getDepartureAirport() != null) {
                route.setDepartureAirport(airportsRepository.findById(routeDTO.getDepartureAirport()).orElseThrow());
            }
            if (routeDTO.getArrivalAirport() != null) {
                route.setArrivalAirport(airportsRepository.findById(routeDTO.getArrivalAirport()).orElseThrow());
            }
            if (routeDTO.getDistance() != null) {
                route.setDistance(routeDTO.getDistance());
            }
            if (routeDTO.getFlightTime() != null) {
                route.setFlightTime(routeDTO.getFlightTime());
            }
            routesRepository.save(route);
            return route;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @DeleteMapping("/routes/{id}")
    public Routes deleteRoute(@PathVariable(value = "id") int id) {
        try {
            Routes route = routesRepository.findById(id).orElseThrow();
            routesRepository.delete(route);
            return route;
        } catch (Exception e) {
            return null;
        }
    }
}
