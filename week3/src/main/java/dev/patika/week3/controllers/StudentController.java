
package dev.patika.week3.controllers;

import dev.patika.week3.controllers.Interface.IBaseController;
import dev.patika.week3.models.Student;
import dev.patika.week3.services.Interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController implements IBaseController<Student> {
    private final IStudentService<Student> iStudentService;

    @Autowired
    public StudentController(IStudentService<Student> iStudentService){
        this.iStudentService = iStudentService;
    }

    @Override
    @GetMapping("/students")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(iStudentService.findAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/students/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return new ResponseEntity<>(iStudentService.findById(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateById(@RequestBody Student student,@PathVariable int id) {
        return new ResponseEntity<>(iStudentService.update(student,id),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        iStudentService.deleteById(id);
        return new ResponseEntity<>("the student with id : "+id+" is deleted successfully",HttpStatus.OK);
    }

    @Override
    @PostMapping("/students")
    public ResponseEntity<Student> post(@RequestBody Student student) {
        return new ResponseEntity<>(iStudentService.save(student),HttpStatus.OK);
    }

}