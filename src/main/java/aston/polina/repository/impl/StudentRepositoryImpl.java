package aston.polina.repository.impl;

import aston.polina.model.Student;
import aston.polina.repository.StudentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getById(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root).where(builder.equal(root.get("id"), id));
        return session.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Student> getAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public Student save(Student student) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(student);
        return student;
    }

    @Override
    public Student deleteById(Integer id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Student deleted = session.get(Student.class, id);
        if (deleted != null) {
            session.delete(deleted);
        }
        return deleted;
    }

}
