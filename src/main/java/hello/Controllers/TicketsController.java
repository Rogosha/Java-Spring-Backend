package hello.Controllers;

import hello.Models.*;
import hello.Repositories.*;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TicketsController {
    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private CabinTypesRepository cabinTypesRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/tickets")
    public Iterable<Tickets> getTickets() {
        return ticketsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/tickets/{id}")
    public Optional<Tickets> getTickets(@PathVariable(value = "id") int id) {
        return ticketsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/tickets")
    public Tickets postTickets(@RequestBody TicketsDTO ticketsDTO) {
        Tickets tickets = new Tickets();
        tickets.setUser(usersRepository.findById(ticketsDTO.getUser()).orElseThrow());
        tickets.setSchedule(schedulesRepository.findById(ticketsDTO.getSchedule()).orElseThrow());
        tickets.setCabinType(cabinTypesRepository.findById(ticketsDTO.getCabinType()).orElseThrow());
        tickets.setFirstName(ticketsDTO.getFirstName());
        tickets.setLastName(ticketsDTO.getLastName());
        tickets.setEmail(ticketsDTO.getEmail());
        tickets.setPhone(ticketsDTO.getPhone());
        tickets.setPassportNumber(ticketsDTO.getPassportNumber());
        tickets.setCountry(countriesRepository.findById(ticketsDTO.getCountry()).orElseThrow());
        tickets.setBookingReference(ticketsDTO.getBookingReference());
        tickets.setConfirmed(ticketsDTO.getConfirmed());
        ticketsRepository.save(tickets);
        return tickets;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/tickets")
    public Tickets putTickets(@RequestBody TicketsDTO ticketsDTO) {
        Response response = new Response();
        try {
            Tickets tickets = ticketsRepository.findById(ticketsDTO.getId()).orElseThrow();
            if (ticketsDTO.getUser() != null) {
                tickets.setUser(usersRepository.findById(ticketsDTO.getUser()).orElseThrow());
            }
            if (ticketsDTO.getSchedule() != null) {
                tickets.setSchedule(schedulesRepository.findById(ticketsDTO.getSchedule()).orElseThrow());
            }
            if (ticketsDTO.getCabinType() != null) {
                tickets.setCabinType(cabinTypesRepository.findById(ticketsDTO.getCabinType()).orElseThrow());
            }
            if (ticketsDTO.getFirstName() != null) {
                tickets.setFirstName(ticketsDTO.getFirstName());
            }
            if (ticketsDTO.getLastName() != null) {
                tickets.setLastName(ticketsDTO.getLastName());
            }
            if (ticketsDTO.getEmail() != null) {
                tickets.setEmail(ticketsDTO.getEmail());
            }
            if (ticketsDTO.getPhone() != null) {
                tickets.setPhone(ticketsDTO.getPhone());
            }
            if (ticketsDTO.getPassportNumber() != null) {
                tickets.setPassportNumber(ticketsDTO.getPassportNumber());
            }
            if (ticketsDTO.getCountry() != null) {
                tickets.setCountry(countriesRepository.findById(ticketsDTO.getCountry()).orElseThrow());
            }
            if (ticketsDTO.getBookingReference() != null) {
                tickets.setBookingReference(ticketsDTO.getBookingReference());
            }
            if (ticketsDTO.getConfirmed() != null){
                tickets.setConfirmed(ticketsDTO.getConfirmed());
            }
            ticketsRepository.save(tickets);
            return tickets;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/tickets/{id}")
    public Tickets deleteTickets(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Tickets tickets = ticketsRepository.findById(id).orElseThrow();
            ticketsRepository.delete(tickets);
            return tickets;
        } catch (Exception e) {
            return null;
        }
    }

}
