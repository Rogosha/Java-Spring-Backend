package hello.Controllers;

import hello.Models.Schedules;
import hello.Repositories.SchedulesRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SchedulesController {
    @Autowired
    private SchedulesRepository schedulesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/schedules")
    public Iterable<Schedules> getSchedules() {
        return schedulesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/schedules/{id}")
    public Optional<Schedules> getSchedule(@PathVariable(value = "id") int id) {
        return schedulesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/schedules")
    public Integer postSchedule(@RequestBody Schedules schedule) {
        schedulesRepository.save(schedule);
        return schedule.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/schedules")
    public String putSchedule(@RequestBody Schedules newSchedule) {
        Response response = new Response();
        try {
            Schedules schedule = schedulesRepository.findById(newSchedule.getId()).orElseThrow();
            if (newSchedule.getDate() != null) {
                schedule.setDate(newSchedule.getDate());
            }
            if (newSchedule.getTime() != null) {
                schedule.setTime(newSchedule.getTime());
            }
            if (newSchedule.getAircraft() != null) {
                schedule.setAircraft(newSchedule.getAircraft());
            }
            if (newSchedule.getRoute() != null) {
                schedule.setRoute(newSchedule.getRoute());
            }
            if (newSchedule.getFlightNumber() != null) {
                schedule.setFlightNumber(newSchedule.getFlightNumber());
            }
            if (newSchedule.getEconomyPrice() != null) {
                schedule.setEconomyPrice(newSchedule.getEconomyPrice());
            }
            if (newSchedule.getConfirmed() != null) {
                schedule.setConfirmed(newSchedule.getConfirmed());
            }
            schedulesRepository.save(schedule);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Schedules aircraft = schedulesRepository.findById(id).orElseThrow();
            schedulesRepository.delete(aircraft);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
