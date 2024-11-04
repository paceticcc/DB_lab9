package models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;

   @Column
   private int idPublishingHouse;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_publishing_house")
//    private PublishingHouse publishingHouse;
    @Column(name = "publishing_date")
    private java.sql.Date publishingDate;
    @Column(name = "price")
    private java.math.BigDecimal price;
    @Column(name = "rating", columnDefinition = "real")
    private float rating;

//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<BookSale> bookSaleList;

    public Book() {
    }

    public Book(
            String title,
            String author,
            int idPublishingHouse,
            java.sql.Date publishingDate,
            java.math.BigDecimal price,
            float rating)
    {
        this.title = title;
        this.author = author;
        this.idPublishingHouse = idPublishingHouse;
        this.publishingDate = publishingDate;
        this.price = price;
        this.rating = rating;
//        bookSaleList = new ArrayList<>();
    }

    public int getId() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingHouse() {
        return idPublishingHouse;
    }

    public void setIdPublishingHouse(int idPublishingHouse) {
//        this.publishingHouse.setTitle(publishingHouse.getTitle());
//        this.publishingHouse.setPhone(publishingHouse.getPhone());
//        this.publishingHouse.setCountry(publishingHouse.getCountry());
//        this.publishingHouse.setCity(publishingHouse.getCity());
//        this.publishingHouse.setAddress(publishingHouse.getAddress());
        //this.publishingHouse = publishingHouse;
        this.idPublishingHouse = idPublishingHouse;
    }

    public java.sql.Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(java.sql.Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "book: " +
                "id: " + this.idBook +
                ", title: '" + this.title + '\'' +
                ", author: '" + this.author + '\'' +
                ", publishing house: '" + this.idPublishingHouse + '\'' +
                ", publishing date: '" + this.publishingDate.toString() + '\'' +
                ", price: '" + this.price + '\'' +
                ", rating: '" + this.rating + '\'';
    }
}
