package com.bookstore.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BookMain {
    private static final String BOOKSTORE_XML = "bookstore.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        convertXMLToObject();

//        List <Book> bookList = new ArrayList<>();
//        List<String> authours = new ArrayList<>();
//
//        // create books
//        Book book1 = new Book();
//        book1.setName("Everyday Italian");
//        book1.setYear("2005");
//        book1.setAuthor(Arrays.asList("Giada De Laurentiis", "Sam T. Bruce"));
//        book1.setPrice(30.00);
//        bookList.add(book1);
//
//        Book book2 = new Book();
//        book2.setName("Harry Potter");
//        book2.setYear("2005");
////        book2.setAuthor("J K. Rowling");
//        book2.setAuthor(Arrays.asList("J K. Rowling", "Erik T. Ray"));
//        book2.setPrice(29.99);
//        bookList.add(book2);
//
//        Book book3 = new Book();
//        book2.setName("Learning XML");
//        book2.setYear("2003");
//        book2.setAuthor(Arrays.asList("Erik T. Ray"));
//        book2.setPrice(39.95);
//        bookList.add(book3);
//
//        // create bookstore, assigning book
//        Bookstore bookstore = new Bookstore();
//        bookstore.setBookList(bookList);
//
//        convertObjectToXML(bookstore);
    }

    private static Bookstore convertXMLToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller un = context.createUnmarshaller();
            Bookstore bookstore = (Bookstore) un.unmarshal(new File(BOOKSTORE_XML));
            List < Book > list = bookstore.getBooksList();
            for (Book book: list) {
                System.out.println("Book: " + book.getName() + " from " + book.getAuthor() + book.getPrice() + book.getYear());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXML(Bookstore bookstore) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(bookstore, System.out);

        // Write to File
        m.marshal(bookstore, new File(BOOKSTORE_XML));
    }
}