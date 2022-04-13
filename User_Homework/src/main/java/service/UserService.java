package service;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    Random random=new Random();
    static String generateName(int n)
    {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar);
        }
        return r.toString();
    }

    public List<User>createUsers(){
        List<User>users=new ArrayList<>();
        for(int i=0;i<3;++i){
            users.add(new User(generateName(10),random.nextInt(101)));
        }
        return users;
    }

    public List<User> usersUnderEighteen(List<User> users) {
        return users.stream().filter(age -> age.getAge() < 18).collect(Collectors.toList());
    }

    public List<User> doubleAges(List<User> users) {
        users.stream().forEach(s -> s.setAge(s.getAge() * 2));
        return users;
    }

    public User getLastUser(List<User> userList) {
        return userList.stream().reduce((first, second) -> second).orElse(null);
    }

    public List<Optional<User>> getLowestAndHighest(List<User> userList) {
        List<Optional<User>> oldestAndYoungest = new ArrayList<>();
        Optional<User> optional = userList.stream().max((p1, p2) -> p1.getAge() - p2.getAge());
        oldestAndYoungest.add(optional);
        optional = userList.stream().min((p1, p2) -> p1.getAge() - p2.getAge());
        oldestAndYoungest.add(optional);
        return oldestAndYoungest;
    }

    public List<User> eliminateTheDuplicates(List<User>users){
        return users.stream().distinct().collect(Collectors.toList());
    }

    public List<User> alexAndDinuFilter(List<User> userList) {
        //Filter users with age > 30, transform their names to uppercase and sort them descending by age
        List<User> users;
        users = userList.stream().filter(user -> user.getAge() > 30).collect(Collectors.toList());
        users.stream().forEach(u -> u.setName(u.getName().toUpperCase()));
        users.sort(Comparator.comparing(User::getAge).reversed());

        return users;

    }
}
