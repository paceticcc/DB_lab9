package models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "stores")
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store")
    private int idStore;
    @Column(name = "rating", columnDefinition = "real")
    private float rating;
    @Column(name = "phone")
    private String phone;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;

    public Stores() {
    }

    public Stores(
            float rating,
            String phone,
            String country,
            String city,
            String address)
    {
        this.rating = rating;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return idStore;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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
        return "store: " +
                "id: " + idStore +
                ", rating: '" + rating + '\'' +
                ", phone: '" + phone + '\'' +
                ", country: '" + country + '\'' +
                ", city: '" + city + '\'' +
                ", address: '" + address + '\'';
    }
}
