package hello.Controllers;

import hello.Models.*;
import hello.Models.DTOs.SchedulesDTO;
import hello.Models.DTOs.SchedulesUpdateDTO;
import hello.Repositories.AircraftsRepository;
import hello.Repositories.AirportsRepository;
import hello.Repositories.RoutesRepository;
import hello.Repositories.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SchedulesController {
    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private AircraftsRepository aircraftsRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private AirportsRepository airportsRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/schedules")
    public Iterable<Schedules> getSchedules() {
        return schedulesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/schedules/{id}")
    public Optional<Schedules> getSchedule(@PathVariable(value = "id") int id) {
        return schedulesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
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

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PutMapping("/schedules")
    public Schedules putSchedule(@RequestBody SchedulesDTO scheduleDTO) {
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

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @DeleteMapping("/schedules/{id}")
    public Schedules deleteSchedule(@PathVariable(value = "id") int id) {
        try {
            Schedules schedule = schedulesRepository.findById(id).orElseThrow();
            schedulesRepository.delete(schedule);
            return schedule;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PostMapping("/schedules/update")
    public Schedules updateSchedule(@RequestBody SchedulesUpdateDTO[] schedulesUpdateDTO) {
        Schedules schedules = null;
        for (int i = 0; i < schedulesUpdateDTO.length; i++) {
            Schedules schedule = null;
            Optional<Schedules> scheduleTemp = schedulesRepository.findByFlightNumberAndDate(schedulesUpdateDTO[i].getFlightNumber(), schedulesUpdateDTO[i].getDate());
            if (schedulesUpdateDTO[i].getAction().equals("ADD") && !scheduleTemp.isPresent()) {
                    schedule = new Schedules();
                    schedule.setDate(schedulesUpdateDTO[i].getDate());
                    schedule.setFlightNumber(schedulesUpdateDTO[i].getFlightNumber());
            } else if (schedulesUpdateDTO[i].getAction().equals("EDIT") && scheduleTemp.isPresent()) {
                schedule = scheduleTemp.orElseThrow();
            } else {
                throw new NoSuchElementException("No value present");
            }
            if (schedule != null) {
                schedule.setTime(schedulesUpdateDTO[i].getTime());
                Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO[i].getDepartureAirport()).orElseThrow();
                Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO[i].getArrivalAirport()).orElseThrow();
                Routes route = routesRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport).orElseThrow();
                schedule.setRoute(route);
                schedule.setAircraft(aircraftsRepository.findById(schedulesUpdateDTO[i].getAircraft()).orElseThrow());
                schedule.setEconomyPrice(schedulesUpdateDTO[i].getEconomyPrice());
                schedule.setConfirmed(schedulesUpdateDTO[i].getConfirmed().equals("OK"));
                schedulesRepository.save(schedule);
            }
        }
        return null;
    }
//    {
//        "date":	"2017-10-04",           - дата вылета
//        "departureAirport": "DOH",      - аэропорт вылета
//        "arrivalAirport": "BAH" -       - aэропорт прибытия
//    }
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PostMapping("/schedules/filter")
    public Iterable<Schedules> searchSchedules(@RequestBody SchedulesUpdateDTO schedulesUpdateDTO){
        Iterable<Schedules> schedulesIterable;
        if (schedulesUpdateDTO.getDate() != null){
            if (schedulesUpdateDTO.getDepartureAirport() != null) {
                if (schedulesUpdateDTO.getArrivalAirport() != null) {
                    Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getDepartureAirport()).orElseThrow();
                    Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getArrivalAirport()).orElseThrow();
                    Optional<Routes> route = routesRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);
                    schedulesIterable = schedulesRepository.findByRouteAndDate(route.get(),schedulesUpdateDTO.getDate());
                } else {
                    Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getDepartureAirport()).orElseThrow();
                    Iterable<Routes> routes = routesRepository.findByDepartureAirport(departureAirport);
                    Deque<Schedules> deque = new ArrayDeque<>();
                    for (Routes routeTemp : routes){
                        schedulesIterable = schedulesRepository.findByRouteAndDate(routeTemp ,schedulesUpdateDTO.getDate());
                        for (Schedules scheduleTemp: schedulesIterable){
                            deque.add(scheduleTemp);
                        }
                    }
                    schedulesIterable = deque;
                }
            } else {
                if (schedulesUpdateDTO.getArrivalAirport() != null) {
                    Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getArrivalAirport()).orElseThrow();
                    Iterable<Routes> routes = routesRepository.findByArrivalAirport(arrivalAirport);
                    Deque<Schedules> deque = new ArrayDeque<>();
                    for (Routes routeTemp : routes){
                        schedulesIterable = schedulesRepository.findByRouteAndDate(routeTemp ,schedulesUpdateDTO.getDate());
                        for (Schedules scheduleTemp: schedulesIterable){
                            deque.add(scheduleTemp);
                        }
                    }
                    schedulesIterable = schedulesRepository.findByDate(schedulesUpdateDTO.getDate());
                } else {
                    schedulesIterable = schedulesRepository.findByDate(schedulesUpdateDTO.getDate());
                }
            }
        } else {
            if (schedulesUpdateDTO.getDepartureAirport() != null) {
                if (schedulesUpdateDTO.getArrivalAirport() != null) {
                    Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getDepartureAirport()).orElseThrow();
                    Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getArrivalAirport()).orElseThrow();
                    Routes route = routesRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport).orElseThrow();
                    schedulesIterable = schedulesRepository.findByRoute(route);
                } else {
                    Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getDepartureAirport()).orElseThrow();
                    Iterable<Routes> routes = routesRepository.findByDepartureAirport(departureAirport);
                    Deque<Schedules> deque = new ArrayDeque<>();
                    for (Routes routeTemp : routes){
                        schedulesIterable = schedulesRepository.findByRoute(routeTemp);
                        for (Schedules scheduleTemp: schedulesIterable){
                            deque.add(scheduleTemp);
                        }
                    }
                    schedulesIterable = deque;
                }
            } else {
                if (schedulesUpdateDTO.getArrivalAirport() != null) {
                    Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getArrivalAirport()).orElseThrow();
                    Iterable<Routes> routes = routesRepository.findByArrivalAirport(arrivalAirport);

                    Deque<Schedules> deque = new ArrayDeque<>();
                    for (Routes routeTemp : routes){
                        schedulesIterable = schedulesRepository.findByRoute(routeTemp);
                        for (Schedules scheduleTemp: schedulesIterable){
                            deque.add(scheduleTemp);
                        }
                    }

                    schedulesIterable = deque;
                } else {
                    schedulesIterable = schedulesRepository.findAll();
                }
            }
        }
        return schedulesIterable;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PostMapping("/schedules/search")
    public Deque<Deque<Schedules>> searchRoutes(@RequestBody SchedulesUpdateDTO schedulesUpdateDTO){
        Airports departureAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getDepartureAirport()).orElseThrow();
        Airports arrivalAirport = airportsRepository.findByIATACode(schedulesUpdateDTO.getArrivalAirport()).orElseThrow();

        int i = 0;
        Deque<Deque<Schedules>> schedules = new ArrayDeque<>();
        if (routesRepository.findByDepartureAirportAndArrivalAirport(departureAirport,arrivalAirport) != null) {
            try {
                Routes route = routesRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport).orElseThrow();
                if (schedulesRepository.findByRouteAndDate(route, schedulesUpdateDTO.getDate()) != null) {
                    for (Schedules schedulesTemp : schedulesRepository.findByRouteAndDate(route, schedulesUpdateDTO.getDate())) {
                        Deque<Schedules> dequeTemp = new ArrayDeque<>();
                        dequeTemp.add(schedulesTemp);
                        schedules.add(dequeTemp);
                    }
                }
            } catch (Exception _) {

            }
        }

        Iterable<Routes> fromDepartureAirport = routesRepository.findByDepartureAirport(departureAirport);
        Iterable<Routes> toArrivalAirport = routesRepository.findByArrivalAirport(arrivalAirport);

        for(Routes departRoute: fromDepartureAirport){
           for (Routes arriRoute: toArrivalAirport){
               if ((departRoute.getArrivalAirport().getId() == arriRoute.getDepartureAirport().getId() ) &&
                       (departRoute.getArrivalAirport() != arriRoute.getArrivalAirport())){
                   Iterable<Schedules> departSchedules = schedulesRepository.findByRouteAndDate(departRoute, schedulesUpdateDTO.getDate());
                   Iterable<Schedules> arriSchedules = schedulesRepository.findByRoute(arriRoute);
                   for (Schedules schedulesTemp : departSchedules){
                       for (Schedules schedulesTemp2: arriSchedules){
                           if (schedulesTemp.getTime().plusMinutes(schedulesTemp.getRoute().getFlightTime()).isBefore(schedulesTemp2.getTime())) {
                               Deque<Schedules> dequeTemp = new ArrayDeque<>();
                               dequeTemp.add(schedulesTemp);
                               dequeTemp.add(schedulesTemp2);

                               schedules.add(dequeTemp);
                               break;
                           }
                       }
                   }
               }
           }
        }


        return schedules;
    }
}
