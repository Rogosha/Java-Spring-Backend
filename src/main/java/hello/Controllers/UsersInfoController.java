package hello.Controllers;

import hello.Models.UsersInfo;
import hello.Repositories.UsersInfoRepository;
import hello.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class UsersInfoController {
    @Autowired
    private UsersInfoRepository usersInfoRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/usersinfo")
    public Iterable<UsersInfo> getUsersInfo() {
        Iterable<UsersInfo> usersInfo = usersInfoRepository.findAll();
        return usersInfo;
    }

    @GetMapping("/usersinfo/{id}")
    public Optional<UsersInfo> getUserInfo(@PathVariable(value = "id") int id) {
        Optional<UsersInfo> userInfo = usersInfoRepository.findById(id);
        return userInfo;
    }

    @PostMapping("/usersinfo")
    public Integer postUserInfo(
            @RequestParam(name = "UserID") Integer userID,
            @RequestParam(name = "LogInTime") String logInTimeString,
            @RequestParam(name = "LogOutTime") String logOutTimeString,
            @RequestParam(name = "CrashReason", required = false) String crashReason,
            @RequestParam(name = "IsSoftCrash", required = false) Boolean isSoftwareCrash,
            @RequestParam(name = "IsSystemCrash", required = false) Boolean isSystemCrash,
            @RequestParam(name = "BlockingReason", required = false) String blockingReason){
            LocalDateTime logInTime = LocalDateTime.parse(logInTimeString, DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy"));
            LocalDateTime logOutTime = LocalDateTime.parse(logOutTimeString, DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy"));
            UsersInfo userInfo = new UsersInfo( usersRepository.findById(userID).orElseThrow(),
                                                logInTime,
                                                logOutTime,
                                                crashReason,
                                                isSoftwareCrash,
                                                isSystemCrash,
                                                blockingReason);
        usersInfoRepository.save(userInfo);
        return userInfo.getId();
    }
    @PutMapping("/usersinfo/{id}")
    public String putUserInfo(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "LogInTime", required = false) String logInTimeString,
            @RequestParam(name = "LogOutTime", required = false) String logOutTimeString,
            @RequestParam(name = "CrashReason", required = false) String crashReason,
            @RequestParam(name = "IsSoftCrash", required = false) Boolean isSoftwareCrash,
            @RequestParam(name = "IsSystemCrash", required = false) Boolean isSystemCrash,
            @RequestParam(name = "BlockingReason", required = false) String blockingReason){
        LocalDateTime logInTime;
        LocalDateTime logOutTime;
        try {
            UsersInfo userInfo = usersInfoRepository.findById(id).orElseThrow();
            if (logInTimeString != null) {
                logInTime = LocalDateTime.parse(logInTimeString, DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy"));
            } else{
                logInTime = userInfo.getLogInTime();
            }

            if (logOutTimeString != null) {
                logOutTime = LocalDateTime.parse(logOutTimeString, DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy"));
            } else{
                logOutTime = userInfo.getLogOutTime();
            }

            userInfo.setLogInTime(logInTime);
            userInfo.setLogOutTime(logOutTime);
            userInfo.setCrashReason(crashReason);
            userInfo.setSoftwareCrash(isSoftwareCrash);
            userInfo.setSystemCrash(isSoftwareCrash);
            userInfo.setBlockingReason(blockingReason);
            usersInfoRepository.save(userInfo);
            return "OK";
        } catch (Exception e){
            return "NOT OK";
        }
    }

    @DeleteMapping("/usersinfo/{id}")
    public String deleteUserInfo(
            @PathVariable(value = "id") int id) {
        try {
            UsersInfo userInfo = usersInfoRepository.findById(id).orElseThrow();
            usersInfoRepository.delete(userInfo);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
