package models;

import javax.persistence.Entity;
import java.util.Objects;
@Entity
public class PermanentTeacher extends Instructor {
    private double fixedSalary;

    public PermanentTeacher(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentTeacher that = (PermanentTeacher) o;
        return Double.compare(that.fixedSalary, fixedSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fixedSalary);
    }

    @Override
    public String toString() {
        return "PermanentTeacher{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
