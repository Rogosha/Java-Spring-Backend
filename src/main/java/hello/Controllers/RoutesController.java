package hello.Controllers;

import hello.Models.Routes;
import hello.Repositories.RoutesRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoutesController {
    @Autowired
    private RoutesRepository routesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/routes")
    public Iterable<Routes> getRoute() {
        return routesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/routes/{id}")
    public Optional<Routes> getRoute(@PathVariable(value = "id") int id) {
        return routesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/routes")
    public Integer postRoute(@RequestBody Routes route) {
        routesRepository.save(route);
        return route.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/routes")
    public String putRoute(@RequestBody Routes newRoute) {
        Response response = new Response();
        try {
            Routes route = routesRepository.findById(newRoute.getId()).orElseThrow();
            if (newRoute.getDepartureAirport() != null) {
                route.setDepartureAirport(newRoute.getDepartureAirport());
            }
            if (newRoute.getArrivalAirport() != null) {
                route.setArrivalAirport(newRoute.getArrivalAirport());
            }
            if (newRoute.getDistance() != null) {
                route.setDistance(newRoute.getDistance());
            }
            if (newRoute.getFlightTime() != null) {
                route.setFlightTime(newRoute.getFlightTime());
            }
            routesRepository.save(route);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/routes/{id}")
    public String deleteRoute(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Routes route = routesRepository.findById(id).orElseThrow();
            routesRepository.delete(route);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
