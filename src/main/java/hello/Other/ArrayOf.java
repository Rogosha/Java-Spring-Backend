package hello.Other;

import hello.Models.Users;
import hello.Models.UsersBlocking;
import hello.Models.UsersLogs;

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
    public static UsersBlocking[] UsersBlocking(Iterable<UsersBlocking> usersIterable){
        List<UsersBlocking> usersList = new ArrayList<>();
        for (UsersBlocking usersBlocking : usersIterable){
            usersList.add(usersBlocking);
        }
        UsersBlocking[] usersBlockingArray = new UsersBlocking[usersList.size()];
        usersList.toArray(usersBlockingArray);
        return usersBlockingArray;
    }
}
