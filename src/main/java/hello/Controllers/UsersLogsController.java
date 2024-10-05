package hello.Controllers;

import hello.Models.UsersLogs;
import hello.Models.UsersLogsDTO;
import hello.Repositories.UsersLogsRepository;
import hello.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersLogsController {
    @Autowired
    private UsersLogsRepository usersLogsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/userslogs")
    public Iterable<UsersLogs> getUsersInfo() {
        return usersLogsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/userslogs/{id}")
    public Optional<UsersLogs> getUserLogs(@PathVariable(value = "id") int id) {
        return usersLogsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/userslogs")
    public UsersLogs postUserLogs(@RequestBody UsersLogsDTO userLogsDTO) {
        UsersLogs userLogs = new UsersLogs();
        userLogs.setUser(usersRepository.findById(userLogsDTO.getUser()).orElseThrow());
        userLogs.setLogInTime(userLogsDTO.getLogInTime());
        userLogs.setLogOutTime(userLogsDTO.getLogOutTime());
        userLogs.setCrashReason(userLogsDTO.getCrashReason());
        userLogs.setSoftwareCrash(userLogsDTO.getSoftwareCrash());
        userLogs.setSystemCrash(userLogsDTO.getSystemCrash());
        usersLogsRepository.save(userLogs);
        return userLogs;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/userslogs")
    public UsersLogs putUserLogs(@RequestBody UsersLogsDTO userLogsDTO) {
        try {
            UsersLogs userLogs = usersLogsRepository.findById(userLogsDTO.getId()).orElseThrow();
            if (userLogsDTO.getUser() != null){
                userLogs.setUser(usersRepository.findById(userLogsDTO.getUser()).orElseThrow());
            }
            if (userLogsDTO.getLogInTime() != null) {
                userLogs.setLogInTime(userLogsDTO.getLogInTime());
            }
            if (userLogsDTO.getLogOutTime() != null) {
                userLogs.setLogOutTime(userLogsDTO.getLogOutTime());
            }
            if (userLogsDTO.getCrashReason() != null) {
                userLogs.setCrashReason(userLogsDTO.getCrashReason());
            }
            if (userLogsDTO.getSoftwareCrash() != null) {
                userLogs.setSoftwareCrash(userLogsDTO.getSoftwareCrash());
            }
            if (userLogsDTO.getSystemCrash() != null) {
                userLogs.setSystemCrash(userLogsDTO.getSystemCrash());
            }
            usersLogsRepository.save(userLogs);
            return userLogs;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/userslogs/{id}")
    public UsersLogs deleteUserLogs(@PathVariable(value = "id") int id) {
        try {
            UsersLogs userLogs = usersLogsRepository.findById(id).orElseThrow();
            usersLogsRepository.delete(userLogs);
            return userLogs;
        } catch (Exception e) {
            return null;
        }
    }
}
