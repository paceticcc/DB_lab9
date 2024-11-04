package services;


import dao.PublishingHouseDAO;
import models.PublishingHouse;

import java.util.List;

public class PublishingHouseService {
    private PublishingHouseDAO publishingHouseDAO = new PublishingHouseDAO();

    public PublishingHouseService() {
    }

    public PublishingHouse findPublishingHouse(int id) {
        return publishingHouseDAO.findById(id);
    }

    public void savePublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseDAO.save(publishingHouse);
    }

    public void deletePublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseDAO.delete(publishingHouse);
    }

    public List selectPublishingHouseGroupBy() {
        return publishingHouseDAO.selectPublishingHousesCount();
    }

    public void updatePublishingHouse(PublishingHouse publishingHouse, String column, String value) {
        switch (column) {
            case "title": {
                publishingHouse.setTitle(value);
                publishingHouseDAO.update(publishingHouse);
                break;
            }
            case "country": {
                publishingHouse.setCountry(value);
                publishingHouseDAO.update(publishingHouse);
                break;
            }
            case "phone": {
                publishingHouse.setPhone(value);
                publishingHouseDAO.update(publishingHouse);
                break;
            }
            case "address": {
                publishingHouse.setAddress(value);
                publishingHouseDAO.update(publishingHouse);
                break;
            }
            case "city": {
                publishingHouse.setCity(value);
                publishingHouseDAO.update(publishingHouse);
                break;
            }
        }
    }
}
