package hello.Other;

import hello.Models.Users;

import java.util.ArrayList;
import java.util.List;

public interface ArrayOfUsers {
    public static Users[] toArray(Iterable<Users> usersIterable){
        List<Users> usersList = new ArrayList<>();
        for (Users user : usersIterable){
            usersList.add(user);
        }
        Users[] usersArray = new Users[usersList.size()];
        usersList.toArray(usersArray);
        return usersArray;
    }
}
