package dev.patika.week3.services.Interfaces;

public interface ICourseService<Course> extends IBaseService<Course>{
    void deleteByCode(String code);

    Course updateByCode(Course course, String code);
}