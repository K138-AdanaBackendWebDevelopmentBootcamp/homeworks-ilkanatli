package dev.patika.week4.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {

    private double fixedSalary;
    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary);
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary);
    }
}
