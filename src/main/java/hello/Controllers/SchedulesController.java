package hello.Controllers;

import hello.Models.Schedules;
import hello.Models.SchedulesDTO;
import hello.Repositories.AircraftsRepository;
import hello.Repositories.RoutesRepository;
import hello.Repositories.SchedulesRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SchedulesController {
    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private AircraftsRepository aircraftsRepository;

    @Autowired
    private RoutesRepository routesRepository;

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
    public Schedules postSchedule(@RequestBody SchedulesDTO scheduleDTO) {
        Schedules schedule = new Schedules();
        schedule.setDate(scheduleDTO.getDate());
        schedule.setTime(scheduleDTO.getTime());
        schedule.setAircraft(aircraftsRepository.findById(scheduleDTO.getAircraft()).orElseThrow());
        schedule.setRoute(routesRepository.findById(scheduleDTO.getRoute()).orElseThrow());
        schedule.setFlightNumber(scheduleDTO.getFlightNumber());
        schedule.setEconomyPrice(scheduleDTO.getEconomyPrice());
        schedule.setConfirmed(scheduleDTO.getConfirmed());
        schedulesRepository.save(schedule);
        return schedule;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/schedules")
    public Schedules putSchedule(@RequestBody SchedulesDTO scheduleDTO) {
        Response response = new Response();
        try {
            Schedules schedule = schedulesRepository.findById(scheduleDTO.getId()).orElseThrow();
            if (scheduleDTO.getDate() != null) {
                schedule.setDate(scheduleDTO.getDate());
            }
            if (scheduleDTO.getTime() != null) {
                schedule.setTime(scheduleDTO.getTime());
            }
            if (scheduleDTO.getAircraft() != null) {
                schedule.setAircraft(aircraftsRepository.findById(scheduleDTO.getAircraft()).orElseThrow());
            }
            if (scheduleDTO.getRoute() != null) {
                schedule.setRoute(routesRepository.findById(scheduleDTO.getRoute()).orElseThrow());
            }
            if (scheduleDTO.getFlightNumber() != null) {
                schedule.setFlightNumber(scheduleDTO.getFlightNumber());
            }
            if (scheduleDTO.getEconomyPrice() != null) {
                schedule.setEconomyPrice(scheduleDTO.getEconomyPrice());
            }
            if (scheduleDTO.getConfirmed() != null) {
                schedule.setConfirmed(scheduleDTO.getConfirmed());
            }
            schedulesRepository.save(schedule);
            return schedule;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/schedules/{id}")
    public Schedules deleteSchedule(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Schedules schedule = schedulesRepository.findById(id).orElseThrow();
            schedulesRepository.delete(schedule);
            return schedule;
        } catch (Exception e) {
            return null;
        }
    }
}
