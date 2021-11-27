package duy.codegym.service.impl;

import duy.codegym.model.Track;
import duy.codegym.service.IService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class IMediaPlayerService implements IService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Track> findAll() {
        String queryStr = "SELECT t FROM Track AS t";
        TypedQuery<Track> query = entityManager.createQuery(queryStr, Track.class);
        return query.getResultList();
    }

    @Override
    public Track findOne(int id) {
        String queryStr = "SELECT t FROM Track AS t WHERE t.id = :id";
        TypedQuery<Track> query = entityManager.createQuery(queryStr, Track.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Track track) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(track);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Track> save(List<Track> customers) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Track> findAll(List<Integer> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findOne(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Track track) {

    }

    @Override
    public void delete(List<Track> tracks) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Track track) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Track origin = findOne(track.getId());
            origin.setName(track.getName());
            origin.setArtist(track.getArtist());
            origin.setTrackLink(track.getTrackLink());
            origin.setType(track.getType());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
