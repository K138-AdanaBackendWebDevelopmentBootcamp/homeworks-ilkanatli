package dev.patika.week4.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int code;
    private int creditScore;
    @ManyToMany
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Instructor instructor;
}
