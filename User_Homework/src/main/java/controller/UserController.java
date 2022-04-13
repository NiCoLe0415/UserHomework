package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController

public class UserController {
    @Autowired
    UserService userService;

    //Create a stream with 3 users
    @GetMapping("/getAllUsers")
    public List<User> createUserList() {
        return userService.createUsers();
    }

    //Filter users with age < 18
    @GetMapping("/getUsersUnderEighteen")
    public List<User> usersUnderEighteen() {
        return userService.usersUnderEighteen(userService.createUsers());
    }

    //Double users’ age
    @GetMapping("/usersWithAgeDoubled")
    public List<User> doubleAges() {
        return userService.doubleAges(userService.createUsers());
    }

    //Print the last element of the stream
    @GetMapping("/lastElement")
    public User getLastElement() {
        return userService.getLastUser(userService.createUsers());
    }

    //Find the person with the smallest age and the one with the greatest age
    @GetMapping("/oldestAndYoungest")
    public List<Optional<User>> getMinAndMax() {
        return userService.getLowestAndHighest(userService.createUsers());
    }

    //Remove duplicates from the list
    @DeleteMapping ("/duplicateNodes")
    public List<User> duplicateNodes() {
        return userService.eliminateTheDuplicates(userService.createUsers());
    }

    //Filter users with age > 30, transform their names to uppercase and sort them descending by age
    @GetMapping("/alexAndDinuFilter")
    public List<User> megaFilter() {
        return userService.alexAndDinuFilter(userService.createUsers());
    }
}
