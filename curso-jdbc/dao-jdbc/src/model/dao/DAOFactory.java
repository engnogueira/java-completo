package model.dao;

import model.dao.impl.SellerDaoJDBC;
import db.DB;

import java.sql.Connection;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDaoJDBC((Connection) DB.getConnection());
    }

}
