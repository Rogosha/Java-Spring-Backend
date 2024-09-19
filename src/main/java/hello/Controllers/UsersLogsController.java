package hello.Controllers;

import hello.Models.UsersLogs;
import hello.Repositories.UsersInfoRepository;
import hello.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class UsersLogsController {
    @Autowired
    private UsersInfoRepository usersLogsRepository;

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
    public Integer postUserLogs(@RequestBody UsersLogs usersLogs){
        usersLogsRepository.save(usersLogs);
        return usersLogs.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/userslogs/")
    public String putUserLogs(@RequestBody UsersLogs newUserLogs){
        try {
            UsersLogs userLogs = usersLogsRepository.findById(newUserLogs.getId()).orElseThrow();
            if (newUserLogs.getLogInTime() != null) {
                userLogs.setLogInTime(newUserLogs.getLogInTime());
            }
            if (newUserLogs.getLogOutTime() != null) {
                userLogs.setLogOutTime(newUserLogs.getLogOutTime());
            }
            if (newUserLogs.getCrashReason() != null) {
                userLogs.setCrashReason(newUserLogs.getCrashReason() );
            }
            if (newUserLogs.getSoftwareCrash() != null) {
                userLogs.setSoftwareCrash(newUserLogs.getSoftwareCrash());
            }
            if (newUserLogs.getSystemCrash() != null) {
                userLogs.setSystemCrash(newUserLogs.getSystemCrash());
            }
            usersLogsRepository.save(userLogs);
            return "OK";
        } catch (Exception e){
            return "NOT OK";
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/userslogs/{id}")
    public String deleteUserLogs(
            @PathVariable(value = "id") int id) {
        try {
            UsersLogs userInfo = usersLogsRepository.findById(id).orElseThrow();
            usersLogsRepository.delete(userInfo);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
