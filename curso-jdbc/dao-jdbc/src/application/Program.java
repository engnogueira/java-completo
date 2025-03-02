package src.application;


import src.model.entities.Department;
import src.model.entities.Seller;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Program {

//    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@email.com", new Date(), 3000.0, obj);
        System.out.println(obj);
        System.out.println(seller);
    }
}