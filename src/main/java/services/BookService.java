package services;

import dao.BookDAO;
import dao.PublishingHouseDAO;
import models.Book;
import models.PublishingHouse;

import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public BookService() {
    }

    public Book findBook(int id) {
        return bookDAO.findById(id);
    }

    public void saveBook(Book book) {
        bookDAO.save(book);
    }

    public void deleteBook(Book book) {
        bookDAO.delete(book);
    }

    public List selectBookGroupBy() {
        return bookDAO.selectMaxPrice();
    }

    public void updateBook(Book book, String column, String value) {
        switch (column) {
            case "title": {
                book.setTitle(value);
                bookDAO.update(book);
                break;
            }
            case "author": {
                book.setAuthor(value);
                bookDAO.update(book);
                break;
            }
            case "publishing_house": {
                Integer idPublishingHouse = new Integer(value);
//                PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAO();
                //PublishingHouse publishingHouse = publishingHouseDAO.findById(idPublishingHouse);
                book.setIdPublishingHouse(idPublishingHouse);
                bookDAO.update(book);
                break;
            }
            case "publishing_date": {
                Date publishingDate = new Date(0);
                publishingDate.valueOf(value);
                book.setPublishingDate(publishingDate);
                bookDAO.update(book);
                break;
            }
            case "price": {
                BigDecimal price = new BigDecimal(value);
                book.setPrice(price);
                bookDAO.update(book);
                break;
            }
            case "rating": {
                Float rating = new Float(value);
                book.setRating(rating);
                bookDAO.update(book);
                break;
            }
        }
    }
}
