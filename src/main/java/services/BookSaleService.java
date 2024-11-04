package services;

import dao.BookDAO;
import dao.BookSaleDAO;
import dao.ClientDAO;
import dao.StoresDAO;
import models.Book;
import models.BookSale;
import models.Client;
import models.Stores;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class BookSaleService {
    private BookSaleDAO bookSaleDAO = new BookSaleDAO();

    public BookSaleService() {
    }

    public BookSale findBookSale(int id) {
        return bookSaleDAO.findById(id);
    }

    public void saveBookSale(BookSale bookSale) {
        bookSaleDAO.save(bookSale);
    }

    public void deleteBookSale(BookSale bookSale) {
        bookSaleDAO.delete(bookSale);
    }

    public List selectBookSaleGroupBy() {
        return bookSaleDAO.selectSummaryProfit();
    }

    public void updateBookSale(BookSale bookSale, String column, String value) {
        switch (column) {
            case "book_sale_date": {
                Date bookSaleDate = new Date(0);
                bookSaleDate.valueOf(value);
                bookSale.setBookSaleDate(bookSaleDate);
                bookSaleDAO.update(bookSale);
                break;
            }
            case "total_cost": {
                BigDecimal totalCost = new BigDecimal(value);
                bookSale.setTotalCost(totalCost);
                bookSaleDAO.update(bookSale);
                break;
            }
            case "book": {
                Integer bookId = new Integer(value);
                bookSale.setIdBook(bookId);
                bookSaleDAO.update(bookSale);
                break;
            }
            case "client": {
                Integer clientId = new Integer(value);
                bookSale.setIdClient(clientId);
                bookSaleDAO.update(bookSale);
                break;
            }
            case "store": {
                Integer storeId = new Integer(value);
                bookSale.setIdStore(storeId);
                bookSaleDAO.update(bookSale);
                break;
            }
        }
    }
}
