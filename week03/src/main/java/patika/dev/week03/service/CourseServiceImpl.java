package patika.dev.week03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import patika.dev.week03.dao.Interface.ICourseDAO;
import patika.dev.week03.models.Course;
import patika.dev.week03.service.Interface.ICourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService<Course> {


    ICourseDAO iCourseDAO;

    @Autowired
    public CourseServiceImpl(@Qualifier("courseDAOJPAImpl") ICourseDAO iCourseDAO) {

        this.iCourseDAO = iCourseDAO;
    }


    @Override
    public List<Course> findAll() {

        return null;
    }

    @Override
    public Course findById(int id) {

        return null;
    }

    @Override
    public Course save(Course course) {

        return (Course) iCourseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Course uptadeOnDatabese(Course object) {

        return null;
    }
}