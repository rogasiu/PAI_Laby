package com.example.stm.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean status = false;

    @Column(name = "registration_time")
    private LocalDateTime registrationDateTime = LocalDateTime.now();

    //uzytkownik moze miec wiele zadan
    @OneToMany(
            mappedBy = "author"
    )
    private List<Task> tasks = new ArrayList<>();

    public User(String name, String lastName, String email, String password, boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

}
