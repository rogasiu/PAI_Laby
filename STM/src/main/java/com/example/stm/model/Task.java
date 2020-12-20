package com.example.stm.model;

import com.example.stm.model.enums.Status;
import com.example.stm.model.enums.Types;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private String title;

    @Type(type = "text")
    private String description;

    @Column(name = "date_added")
    private LocalDateTime dateAdded = LocalDateTime.now();

    @Enumerated(value = EnumType.STRING)
    private Types type;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    //kazde zadanie posiada jednego autora
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private User author;

    public Task(String title, String description, Types type, Status status, User author) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
        this.author = author;
    }
}
