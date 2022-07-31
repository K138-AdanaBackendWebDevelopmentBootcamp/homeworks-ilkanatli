package dev.patika.week4.repositories;
import dev.patika.week4.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
    Course findByName(String name);
    int deleteByName(String name);
    int deleteAllByName(String name);
    int deleteByNameAndCode(String name, int code);
    int deleteAllByNameEquals(String name);
    int deleteAllByNameLike(String name);
    int deleteAllByNameContains(String name);
}
