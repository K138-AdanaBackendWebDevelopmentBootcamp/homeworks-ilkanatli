package dev.patika.graduationproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary);
    }
}
