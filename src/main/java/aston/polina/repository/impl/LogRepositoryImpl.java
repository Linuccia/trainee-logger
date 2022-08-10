package aston.polina.repository.impl;

import aston.polina.model.Log;
import aston.polina.repository.LogRepository;
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
public class LogRepositoryImpl implements LogRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public LogRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Log getById(Long id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Log> criteria = builder.createQuery(Log.class);
        Root<Log> root = criteria.from(Log.class);
        criteria.select(root).where(builder.equal(root.get("id"), id));
        return session.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Log> getAllByStudentId(Integer studentId) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Log> criteria = builder.createQuery(Log.class);
        Root<Log> root = criteria.from(Log.class);
        criteria.select(root).where(builder.equal(root.get("student").get("id"), studentId));
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public Log save(Log log) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.save(log);
        return log;
    }

    @Override
    public Log update(Log log) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.update(log);
        return log;
    }

}
