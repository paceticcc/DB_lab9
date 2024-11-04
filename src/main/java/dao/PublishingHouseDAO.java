package dao;

import models.PublishingHouse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PublishingHouseDAO {
    public PublishingHouse findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PublishingHouse.class, id);
    }

    public void save(PublishingHouse publishingHouse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(publishingHouse);
        tx1.commit();
        session.close();
    }

    public void update(PublishingHouse publishingHouse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(publishingHouse);
        tx1.commit();
        session.close();
    }

    public void delete(PublishingHouse publishingHouse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(publishingHouse);
        tx1.commit();
        session.close();
    }

    public List selectPublishingHousesCount() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "select new list(ph.country, count(ph.idPublishingHouse)) " +
                    "from PublishingHouse ph group by ph.country")
                    .list();
        }
    }
    /*public List<PublishingHouse> findAll() {
        List<PublishingHouse> publishingHouses = (List<PublishingHouse>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From publishing_house").list();
        return publishingHouses;
    }*/
}
