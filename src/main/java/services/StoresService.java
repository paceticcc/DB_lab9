package services;


import dao.StoresDAO;
import models.Stores;

import java.util.List;

public class StoresService {
    private StoresDAO storesDAO = new StoresDAO();

    public StoresService() {
    }

    public Stores findStore(int id) {
        return storesDAO.findById(id);
    }

    public void saveStore(Stores store) {
        storesDAO.save(store);
    }

    public void deleteStore(Stores store) {
        storesDAO.delete(store);
    }

    public List selectStoresGroupBy() {
        return storesDAO.selectStoreMaxRating();
    }

    public void updateStore(Stores store, String column, String value) {
        switch (column) {
            case "title": {
                Float rating = new Float(value);
                store.setRating(rating);
                storesDAO.update(store);
                break;
            }
            case "country": {
                store.setCountry(value);
                storesDAO.update(store);
                break;
            }
            case "phone": {
                store.setPhone(value);
                storesDAO.update(store);
                break;
            }
            case "address": {
                store.setAddress(value);
                storesDAO.update(store);
                break;
            }
            case "city": {
                store.setCity(value);
                storesDAO.update(store);
                break;
            }
        }
    }
}
