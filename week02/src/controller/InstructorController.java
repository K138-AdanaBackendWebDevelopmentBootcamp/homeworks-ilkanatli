package controller;
import models.Instructor;

import service.InstructorService;



import java.util.List;

public class InstructorController {
    private static InstructorService instructorService = new InstructorService();

    public List<Instructor> findAllInstructor(){
        return instructorService.findAll();

    }

    public Instructor fintInstructorById(int id){

        return  instructorService.findById(id);
    }
    public static void saveInstructor(Instructor instructor) {

        instructorService.saveDatabase(instructor);
    }

}
