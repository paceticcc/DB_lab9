package services;

import dao.ClientDAO;
import models.Client;

import java.util.List;

public class ClientService {
    private ClientDAO clientDAO = new ClientDAO();

    public ClientService() {
    }

    public Client findClient(int id) {
        return clientDAO.findById(id);
    }

    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    public void deleteClient(Client client) {
        clientDAO.delete(client);
    }

    public List selectClientGroupBy() {
        return clientDAO.selectNamesCount();
    }

    public void updateClient(Client client, String column, String value) {
        switch (column) {
            case "name": {
                client.setClientName(value);
                clientDAO.update(client);
                break;
            }
            case "email": {
                client.setEmail(value);
                clientDAO.update(client);
                break;
            }
            case "phone": {
                client.setPhone(value);
                clientDAO.update(client);
                break;
            }
        }
    }
}
