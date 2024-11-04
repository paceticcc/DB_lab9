package models;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "publishing_house")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publishing_house")
    private int idPublishingHouse;
    @Column(name = "title")
    private String title;
    @Column(name = "phone")
    private String phone;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;

    public PublishingHouse() {
    }

    public PublishingHouse(
            String title,
            String phone,
            String country,
            String city,
            String address)
    {
        this.title = title;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return idPublishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "publishing house: " +
                "id: " + this.idPublishingHouse +
                ", title: '" + this.title + '\'' +
                ", phone: '" + this.phone + '\'' +
                ", country: '" + this.country + '\'' +
                ", city: '" + this.city + '\'' +
                ", address: '" + this.address + '\'';
    }
}
