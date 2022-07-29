import java.util.Objects;

public class VisitingResearcher extends Instructor {
    private double hourSalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourSalary) {
        super(name, address, phoneNumber);
        this.hourSalary = hourSalary;
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Double.compare(that.hourSalary, hourSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourSalary);
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourSalary=" + hourSalary +
                '}';
    }
}