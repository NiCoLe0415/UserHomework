package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    private static int id=0;
    private String name;
    private int age;

    public User(String name, int age){
        this.name=name;
        this.age=age;
        ++id;
    }


}
