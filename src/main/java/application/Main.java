package application;

import db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DB.getConnection();
        DB.closeConnection();

    }
}
