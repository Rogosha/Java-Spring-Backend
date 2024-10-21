package hello.Controllers;

import hello.Models.Amenities;
import hello.Models.AmenitiesTickets;
import hello.Models.DTOs.AmenitiesTicketsDTO;
import hello.Models.DTOs.SchedulesUpdateDTO;
import hello.Models.EmbeddedIds.AmenityTicketsId;
import hello.Models.Tickets;
import hello.Repositories.AmenitiesRepository;
import hello.Repositories.AmenitiesTicketsRepository;
import hello.Repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AmenitiesTicketsController {
    @Autowired
    private AmenitiesTicketsRepository amenitiesTicketsRepository;

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenitiestickets")
    public Iterable<AmenitiesTickets> getAmenities() {
        return amenitiesTicketsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenitiestickets/{id}")
    public Deque<AmenitiesTickets> getAmenities(@PathVariable(value = "id") String bookingReference) {
        Deque<AmenitiesTickets> amenitiesTicketsDeque = new ArrayDeque<>();
        Iterable<Tickets> tickets = ticketsRepository.findByBookingReference(bookingReference);
        for (Tickets ticketTemp : tickets){
            Iterable<AmenitiesTickets> amenitiesTickets = amenitiesTicketsRepository.findByTickets(ticketTemp);
            for (AmenitiesTickets amenitiesTicketsTemp: amenitiesTickets){
                amenitiesTicketsDeque.add(amenitiesTicketsTemp);
            }
        }
        return amenitiesTicketsDeque;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/amenitiestickets")
    public AmenitiesTickets postAmenities(@RequestBody AmenitiesTicketsDTO amenitiesTicketsDTO) {

        AmenityTicketsId amenityTicketsId = new AmenityTicketsId(amenitiesTicketsDTO.getAmenities(), amenitiesTicketsDTO.getTickets());

        AmenitiesTickets amenitiesTickets = new AmenitiesTickets(amenityTicketsId);

        amenitiesTickets.setTickets(ticketsRepository.findById(amenitiesTicketsDTO.getTickets()).orElseThrow());

        amenitiesTickets.setAmenities(amenitiesRepository.findById(amenitiesTicketsDTO.getAmenities()).orElseThrow());

        if (amenitiesTicketsDTO.getPrice() != null) {
            amenitiesTickets.setPrice(amenitiesTicketsDTO.getPrice());
        } else amenitiesTickets.setPrice(amenitiesTickets.getAmenities().getPrice());

        amenitiesTicketsRepository.save(amenitiesTickets);

        return amenitiesTickets;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/amenitiestickets")
    public AmenitiesTickets putAmenities(@RequestBody AmenitiesTicketsDTO amenitiesTicketsDTO) {
        try {
            AmenityTicketsId amenityTicketsId = new AmenityTicketsId(amenitiesTicketsDTO.getAmenities(), amenitiesTicketsDTO.getTickets());

            AmenitiesTickets amenitiesTickets = new AmenitiesTickets(amenityTicketsId);

            if (amenitiesTicketsDTO.getTickets() != null){
                amenitiesTickets.setTickets(ticketsRepository.findById(amenitiesTicketsDTO.getTickets()).orElseThrow());
            }
            if (amenitiesTicketsDTO.getPrice() != null){
                amenitiesTickets.setPrice(amenitiesTicketsDTO.getPrice());
            }
            if (amenitiesTicketsDTO.getAmenities() != null){
                amenitiesTickets.setAmenities(amenitiesRepository.findById(amenitiesTicketsDTO.getAmenities()).orElseThrow());
            }
            amenitiesTicketsRepository.save(amenitiesTickets);
            return amenitiesTickets;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/amenitiestickets")
    public AmenitiesTickets deleteAmenities(@RequestBody AmenitiesTicketsDTO amenitiesTicketsDTO) {
        try {
            Tickets ticket = ticketsRepository.findById(amenitiesTicketsDTO.getTickets()).orElseThrow();
            Amenities amenity = amenitiesRepository.findById(amenitiesTicketsDTO.getAmenities()).orElseThrow();
            AmenitiesTickets amenitiesTickets = amenitiesTicketsRepository.findByTicketsAndAmenities(ticket, amenity).orElseThrow();
            amenitiesTicketsRepository.delete(amenitiesTickets);
            return amenitiesTickets;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/amenitiestickets/report")
    public Map<String, Map<String, Integer>> amenitiesReport(@RequestBody SchedulesUpdateDTO parameters){
        Map<String, Map<String, Integer>> report = new HashMap<>();
        Map<String, Integer> economyMap = new HashMap<>();
        Map<String, Integer> businessMap = new HashMap<>();
        Map<String, Integer> firstClassMap = new HashMap<>();

        Iterable<AmenitiesTickets> allAmenitiesTickets = amenitiesTicketsRepository.findAll();
        if (parameters.getFlightNumber() != null){
            for (AmenitiesTickets amenitiesTicketsTemp : allAmenitiesTickets) {
                if ((amenitiesTicketsTemp.getTickets().getSchedule().getFlightNumber()
                                                                    .equals(parameters.getFlightNumber())) &&
                    (amenitiesTicketsTemp.getTickets().getSchedule().getDate()
                                                                    .equals(parameters.getDate()))){
                    switch (amenitiesTicketsTemp.getTickets().getCabinType().getName()){
                        case ("Economy") :{
                            economyMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    economyMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                                0) + 1);
                        }
                        case ("Business") :{
                            businessMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    businessMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                            0) + 1);
                        }
                        case ("First Class") :{
                            firstClassMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    firstClassMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                            0) + 1);
                        }

                    }
                }
            }
        } else {
            for (AmenitiesTickets amenitiesTicketsTemp : allAmenitiesTickets) {
                if (amenitiesTicketsTemp.getTickets().getSchedule().getDate().equals(parameters.getDate())){
                    switch (amenitiesTicketsTemp.getTickets().getCabinType().getName()){
                        case ("Economy") :{
                            economyMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    economyMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                            0) + 1);
                        }
                        case ("Business") :{
                            businessMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    businessMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                            0) + 1);
                        }
                        case ("First Class") :{
                            firstClassMap.put( amenitiesTicketsTemp.getAmenities().getService(),
                                    firstClassMap.getOrDefault(amenitiesTicketsTemp.getAmenities().getService(),
                                            0) + 1);
                        }

                    }
                }
            }
        }
        report.put("Economy", economyMap);
        report.put("Business", businessMap);
        report.put("First Class", firstClassMap);
        return  report;
    }

}
