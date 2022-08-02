package dev.patika.graduationproject.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNo;

    @OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
    private List<Course> courses;
    @Setter(AccessLevel.PROTECTED)
    private double salary;

}