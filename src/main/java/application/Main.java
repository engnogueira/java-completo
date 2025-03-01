package application;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            // EXAMPLE 1
            st = conn.prepareStatement(
                "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            // EXAMPLE 2
            st = conn.prepareStatement(
                "INSERT INTO department (Name) VALUES ('D1'), ('D2')",
                Statement.RETURN_GENERATED_KEYS
            );

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! ID = " + id);
                }
            } else {
                System.out.println("No rown affected!");
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
//  GET - Recuperar dados
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        try {
//            conn = DB.getConnection();
//            st = conn.createStatement();
//            rs = st.executeQuery(
//                "SELECT * FROM department"
//            );
//            while (rs.next()) {
//                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DB.closeResultSet(rs);
//            DB.closeStatement(st);
//            DB.closeConnection();
//        }
//    }

