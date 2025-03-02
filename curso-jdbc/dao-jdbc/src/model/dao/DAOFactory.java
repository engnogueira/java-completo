package src.model.dao;

import src.model.dao.impl.SellerDAOImplementsJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDAOImplementsJDBC();
    }

}
