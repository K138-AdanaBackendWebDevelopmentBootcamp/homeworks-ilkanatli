package dev.patika.graduationproject.repositories;


import dev.patika.graduationproject.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByName(String name);
    int deleteByName(String name);
    int deleteAllByName(String name);
    int deleteByNameAndCode(String name, int code);
    int deleteAllByNameEquals(String name);
    int deleteAllByNameLike(String name);
    int deleteAllByNameContains(String name);
}
