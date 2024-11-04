package dao;

import models.Stores;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StoresDAO {
    public Stores findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Stores.class, id);
    }

    public void save(Stores store) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(store);
        tx1.commit();
        session.close();
    }

    public void update(Stores store) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(store);
        tx1.commit();
        session.close();
    }

    public void delete(Stores store) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(store);
        tx1.commit();
        session.close();
    }

    public List selectStoreMaxRating() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "select new list(city, max(rating))" +
                            " from Stores group by city").list();
        }
    }

    /*public List<Stores> findAll() {
        List<Stores> stores = (List<Stores>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From stores").list();
        return stores;
    }*/
}
