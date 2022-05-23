package springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdemo.dao.GeneralDao;
import springdemo.entity.Student;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentService implements GeneralService<Student, Integer> {

    @Autowired
    @Qualifier(value = "studentDao")
    private GeneralDao generalDao;

    @Override
    @Transactional
    public List<Student> getListServ() {
        List <Student>studentList = generalDao.getListDao();
        return studentList;
    }

    @Override
    @Transactional
    public void saveServ(Student entity) {
        generalDao.saveDao(entity);
    }

    @Override
    @Transactional
    public Student getServ(Integer id) {
        Student student =(Student) generalDao.getDao(id);
        return student ;
    }

    @Override
    @Transactional
    public void deleteServ(Student entity) {
        generalDao.deleteDao(entity);
    }
}
