package dev.patika.week4.repositories;

import dev.patika.week4.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long>{
    Instructor findByName(String name);
    Iterable<Instructor> findTop3ByOrderBySalaryDesc();

    void deleteInstructorByName(String name);
}
