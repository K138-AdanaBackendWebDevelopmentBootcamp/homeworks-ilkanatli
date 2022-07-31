package dev.patika.graduationproject.services;

import dev.patika.graduationproject.models.Instructor;
import dev.patika.graduationproject.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    final InstructorRepository instructorRepository;

    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructors::add);
        return instructors;
    }

    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional(readOnly = true)
    public Instructor findById(Long id) {
        return instructorRepository.findById(id).get();
    }

    @Transactional
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Transactional
    public Instructor findByName(String name) {
        return instructorRepository.findByName(name);
    }

    @Transactional
    public void deleteByName(String name) {
        instructorRepository.deleteInstructorByName(name);
    }

    public List<Instructor> topThreeSalaryInstructor(){
        Iterable<Instructor> instructors = instructorRepository.findTop3ByOrderBySalaryDesc();
        List<Instructor> topThree = new ArrayList<>();
        instructors.forEach(topThree::add);
        return topThree;
    }
}
