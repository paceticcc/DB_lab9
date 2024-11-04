package models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "book_sale")
public class BookSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_sale")
    private int idBookSale;
    @Column(name = "book_sale_date")
    private java.sql.Date bookSaleDate;
    @Column(name = "total_cost")
    private java.math.BigDecimal totalCost;
    @Column(name = "id_book")
    private int idBook;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_store")
    private int idStore;

    public BookSale(){

    }

    public BookSale(
            java.sql.Date bookSaleDate,
            java.math.BigDecimal totalCost,
            int idBook,
            int idClient,
            int idStore)
    {
        this.bookSaleDate = bookSaleDate;
        this.totalCost = totalCost;
        this.idBook = idBook;
        this.idClient = idClient;
        this.idStore = idStore;
    }

    public int getId() { return idBookSale; }

    public java.sql.Date getBookSaleDate() {
        return bookSaleDate;
    }

    public void setBookSaleDate(java.sql.Date bookSaleDate) {
        this.bookSaleDate = bookSaleDate;
    }

    public java.math.BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(java.math.BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String toString() {
        return "book sale: " +
                "id: " + this.idBookSale +
                ", book sale date: '" + this.bookSaleDate.toString() + '\'' +
                ", total cost: '" + this.totalCost + '\'' +
                ", book: '" + this.idBook + '\'' +
                ", client: '" + this.idClient + '\'' +
                ", store: '" + this.idStore + '\'';
    }
}



