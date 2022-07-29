
package dev.patika.SchoolManagementSystem03.services;

import dev.patika.SchoolManagementSystem03.DAO.Interfaces.IInstructorDAO;
import dev.patika.SchoolManagementSystem03.models.VisitingResearcher;
import dev.patika.SchoolManagementSystem03.services.Interfaces.IInstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Visiting_researcherServiceImpl implements IInstructorService<VisitingResearcher> {
    private final IInstructorDAO<VisitingResearcher> i_researcherDAO;

    public Visiting_researcherServiceImpl(IInstructorDAO<VisitingResearcher> i_researcherDAO) {
        this.i_researcherDAO = i_researcherDAO;
    }

    @Override
    public VisitingResearcher findByPhoneNumber(Long phone_number) {
        return i_researcherDAO.findByPhoneNumber(phone_number);
    }

    @Override
    public void deleteByPhoneNumber(Long phone_number) {
        i_researcherDAO.deleteByPhoneNumber(phone_number);
    }

    @Override
    public VisitingResearcher updateByPhoneNumber(VisitingResearcher visitingResearcher, Long phone_number) {
        return i_researcherDAO.updateByPhoneNumber(visitingResearcher,phone_number);
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return i_researcherDAO.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return i_researcherDAO.findById(id);
    }

    @Override
    public VisitingResearcher save(VisitingResearcher instructor) {
        return i_researcherDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        i_researcherDAO.deleteById(id);
    }

    @Override
    public VisitingResearcher update(VisitingResearcher instructor, int id) {
        return i_researcherDAO.update(instructor,id);
    }
}