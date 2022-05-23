package springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springdemo.entity.Student;

import java.util.List;

@Repository
public class StudentDao implements GeneralDao<Student,Integer>{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Student> getListDao() {
        // get the current hibernate session
        Session getCurrentSession = sessionFactory.getCurrentSession();
        // create a query
        Query query = getCurrentSession.createQuery("from Student order by name");
        // execute the query and get the result list
        List<Student> resultList = query.getResultList();
        // return the result
        return resultList;
    }

    @Override
    public void saveDao(Student entity) {
        Session getCurrentSession = sessionFactory.getCurrentSession();
        getCurrentSession.saveOrUpdate(entity);
    }

    @Override
    public Student getDao(Integer id) {
        Session getCurrentSession = sessionFactory.getCurrentSession();
        Student student= getCurrentSession.get(Student.class,id);
        return student;
    }

    @Override
    public void deleteDao(Student entity) {
        Session getCurrentSession = sessionFactory.getCurrentSession();
        getCurrentSession.delete(entity);
    }
}
