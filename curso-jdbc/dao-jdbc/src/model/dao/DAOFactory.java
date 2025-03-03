package model.dao;

import model.dao.impl.SellerDaoJDBC;
import db.DB;
import model.entities.Seller;

import java.sql.Connection;
import java.util.List;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDaoJDBC((Connection) DB.getConnection()) {
            @Override
            public List<Seller> findByDepartment() {
                return List.of();
            }
        };
    }

}
