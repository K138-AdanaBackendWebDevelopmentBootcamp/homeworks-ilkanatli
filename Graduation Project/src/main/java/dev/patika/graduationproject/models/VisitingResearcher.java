package dev.patika.graduationproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {
    private double hourlySalary;
    private static final int HOUR_MULTIPLY_MONTH = 8 * 30;
    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary* HOUR_MULTIPLY_MONTH);
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary*HOUR_MULTIPLY_MONTH);
    }
}
