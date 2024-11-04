package org.example;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import services.*;
import utils.HibernateSessionFactoryUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Date;
import java.lang.Float;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        BookService bookService = new BookService();
        ClientService clientService = new ClientService();
        BookSaleService bookSaleService = new BookSaleService();
        PublishingHouseService publishingHouseService = new PublishingHouseService();
        StoresService storesService = new StoresService();
        Scanner input = new Scanner(System.in);
        String action = "";
        System.out.println("Choose action: INSERT, UPDATE, DELETE, SELECT, GROUP_BY, EXIT");
        while (!action.equals("EXIT")) {
            System.out.println("#");
            action = input.nextLine();
            switch (action) {
                case "INSERT": {
                    System.out.println("Type data");
                    String[] data = input.nextLine().split("[\\s]");
                    for (String str : data)
                    {
                        System.out.println(str);
                    }
                    switch (data[0]) {
                        case "book": {
//                            String title = input.next();
//                            String author = input.next();
//                            String publishingHouse = input.next();
//                            String date = input.next();
//                            System.out.println(date);
//                            Date publishingDate = new Date(0);
//                            publishingDate = publishingDate.valueOf(date);
//                            float priceFloat = input.nextFloat();
//                            BigDecimal price = new BigDecimal(priceFloat);
//                            System.out.println(price);
//                            float ratingFloat = input.nextFloat();
//                            BigDecimal rating = new BigDecimal(ratingFloat);
//                            Book book = new Book(title, author, publishingHouse, publishingDate, price, rating);
//                            System.out.println(book.toString());
//                            bookService.saveBook(book);
                            Date publishingDate = new Date(0);
                            publishingDate = publishingDate.valueOf(data[4]);
                            BigDecimal price = new BigDecimal(data[5]);
                            Book book = new Book(
                                    data[1],
                                    data[2],
                                    Integer.parseInt(data[3]),
                                    publishingDate,
                                    price,
                                    Float.parseFloat(data[6]));
                            bookService.saveBook(book);
                            System.out.println("Book №" + book.getId() + " inserted");
                            break;
                        }
                        case "book_sale": {
                            Date bookSaleDate = new Date(0);
                            bookSaleDate = bookSaleDate.valueOf(data[1]);
                            BigDecimal totalCost = new BigDecimal(data[2]);
                            BookSale bookSale = new BookSale(
                                    bookSaleDate,
                                    totalCost,
                                    Integer.parseInt(data[3]),
                                    Integer.parseInt(data[4]),
                                    Integer.parseInt(data[5])
                            );
                            bookSaleService.saveBookSale(bookSale);
                            System.out.println("Book Sale №" + bookSale.getId() + " inserted");
                            break;
                        }
                        case "client": {
                            Client client = new Client(
                                    data[1],
                                    data[2],
                                    data[3]
                            );
                            clientService.saveClient(client);
                            System.out.println("Client №" + client.getId() + " inserted");
                            break;
                        }
                        case "publishing_house": {
                            PublishingHouse publishingHouse = new PublishingHouse(
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4],
                                    data[5]
                            );
                            publishingHouseService.savePublishingHouse(publishingHouse);
                            System.out.println("Publishing house №" + publishingHouse.getId() + " inserted");
                            break;
                        }
                        case "store": {
                            Stores store = new Stores(
                                    Float.parseFloat(data[1]),
                                    data[2],
                                    data[3],
                                    data[4],
                                    data[5]
                            );
                            storesService.saveStore(store);
                            System.out.println("Store №" + store.getId() + " inserted");
                            break;
                        }
                    }
                    break;
                }
                case "UPDATE": {
                    System.out.println("Type entity, id, column and value");
                    String[] data = input.nextLine().split("[\\s]");
                    String column = data[2];
                    String value = data[3];
                    switch (data[0]) {
                        case "book": {
                            Book book = bookService.findBook(Integer.parseInt(data[1]));
                            bookService.updateBook(book, column, value);
                            break;
                        }
                        case "book_sale": {
                            BookSale bookSale = bookSaleService.findBookSale(Integer.parseInt(data[1]));
                            bookSaleService.updateBookSale(bookSale, column, value);
                            break;
                        }
                        case "client": {
                            Client client = clientService.findClient(Integer.parseInt(data[1]));
                            clientService.updateClient(client, column, value);
                            break;
                        }
                        case "publishing_house": {
                            PublishingHouse publishingHouse = publishingHouseService.findPublishingHouse(Integer.parseInt(data[1]));
                            publishingHouseService.updatePublishingHouse(publishingHouse, column, value);
                            break;
                        }
                        case "store": {
                            Stores store = storesService.findStore(Integer.parseInt(data[1]));
                            storesService.updateStore(store, column, value);
                            break;
                        }
                    }
//                    String sql = input.nextLine();
//                    session = sessionFactory.openSession();
//                    Transaction tx = session.beginTransaction();
//                    Query query = session.createQuery(sql);
//                    int result = query.executeUpdate();
//                    System.out.println(result);
//                    tx.commit();
//                    session.close();
                    break;
                }
                case "DELETE": {
                    System.out.println("Type entity and id");
                    String entity = input.next();
                    int id = input.nextInt();
                    switch(entity){
                        case "book": {
                            Book book = bookService.findBook(id);
                            bookService.deleteBook(book);
                            break;
                        }
                        case "book_sale": {
                            BookSale bookSale = bookSaleService.findBookSale(id);
                            bookSaleService.deleteBookSale(bookSale);
                            break;
                        }
                        case "client": {
                            Client client = clientService.findClient(id);
                            clientService.deleteClient(client);
                            break;
                        }
                        case "publishing_house": {
                            PublishingHouse publishingHouse = publishingHouseService.findPublishingHouse(id);
                            publishingHouseService.deletePublishingHouse(publishingHouse);
                            break;
                        }
                        case "store": {
                            Stores store = storesService.findStore(id);
                            storesService.deleteStore(store);
                            break;
                        }
                    }

//                    String sql = input.nextLine();
//                    session = sessionFactory.openSession();
//                    Transaction tx = session.beginTransaction();
//                    Query query = session.createQuery(sql);
//                    int result = query.executeUpdate();
//                    System.out.println(result);
//                    tx.commit();
//                    session.close();
                    break;
                }
                case "SELECT": {
                    System.out.println("Type entity and ID");
                    String entity = input.next();
                    int id = Integer.parseInt(input.next());
                    switch(entity) {
                        case "book": {
                            System.out.println(bookService.findBook(id).toString());
                            break;
                        }
                        case "book_sale": {
                            System.out.println(bookSaleService.findBookSale(id).toString());
                            break;
                        }
                        case "client": {
                            System.out.println(clientService.findClient(id).toString());
                            break;
                        }
                        case "publishing_house": {
                            System.out.println(publishingHouseService.findPublishingHouse(id).toString());
                            break;
                        }
                        case "store": {
                            System.out.println(storesService.findStore(id).toString());
                            break;
                        }
                    }
//                    String sql = input.nextLine();
//                    session = sessionFactory.openSession();
//                    Query query = session.createQuery(sql);
//                    List list = query.list();
//                    list.forEach(System.out::println);
//                    session.close();
                    break;
                }
                case "GROUP_BY": {
                    System.out.println("Type entity");
                    switch(input.next()) {
                        case "book": {
                            bookService.selectBookGroupBy().forEach(System.out::println);
                            break;
                        }
                        case "book_sale": {
                            bookSaleService.selectBookSaleGroupBy().forEach(System.out::println);
                            break;
                        }
                        case "client": {
                            clientService.selectClientGroupBy().forEach(System.out::println);
                            break;
                        }
                        case "publishing_house": {
                            publishingHouseService.selectPublishingHouseGroupBy().forEach(System.out::println);
                            break;
                        }
                        case "store": {
                            storesService.selectStoresGroupBy().forEach(System.out::println);
                            break;
                        }
                    }
                }
                case "EXIT":
                    continue;
            }
        }
    }
}
