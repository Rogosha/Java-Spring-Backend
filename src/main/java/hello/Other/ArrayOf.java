package hello.Other;

import hello.Models.Users;
import hello.Models.UsersInfo;

import java.util.ArrayList;
import java.util.List;

public interface ArrayOf {
    public static Users[] Users(Iterable<Users> usersIterable){
        List<Users> usersList = new ArrayList<>();
        for (Users user : usersIterable){
            usersList.add(user);
        }
        Users[] usersArray = new Users[usersList.size()];
        usersList.toArray(usersArray);
        return usersArray;
    }
    public static UsersInfo[] UsersInfo(Iterable<UsersInfo> usersIterable){
        List<UsersInfo> usersList = new ArrayList<>();
        for (UsersInfo usersInfo : usersIterable){
            usersList.add(usersInfo);
        }
        UsersInfo[] usersInfoArray = new UsersInfo[usersList.size()];
        usersList.toArray(usersInfoArray);
        return usersInfoArray;
    }
}
