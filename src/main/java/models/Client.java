package models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client(
            String clientName,
            String phone,
            String email)
    {
        this.clientName = clientName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "client: " +
                "id: " + idClient +
                ", name: '" + clientName + '\'' +
                ", phone: '" + phone + '\'' +
                ", email: '" + email + '\'';
    }
}
