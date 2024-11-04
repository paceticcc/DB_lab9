package dao;

import models.Book;
import models.BookSale;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class BookSaleDAO {
    public BookSale findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        BookSale bookSale = session.get(BookSale.class, id);
        tx1.commit();
        session.close();
        return bookSale;
    }

    public void save(BookSale bookSale) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(bookSale);
        tx1.commit();
        session.close();
    }

    public void update(BookSale bookSale) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(bookSale);
        tx1.commit();
        session.close();
    }

    public void delete(BookSale bookSale) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(bookSale);
        tx1.commit();
        session.close();
    }

    public List selectSummaryProfit() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "select new list(bs.idStore, sum(bs.totalCost))" +
                    " from BookSale bs group by bs.idStore")
                    .list();
        }
    }
}
