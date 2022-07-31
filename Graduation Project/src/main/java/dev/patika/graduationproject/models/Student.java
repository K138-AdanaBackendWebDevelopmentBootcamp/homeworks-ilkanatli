package dev.patika.graduationproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String address;
    private String gender;
    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courseList;


}
