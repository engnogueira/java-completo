package application;


import java.sql.*;

import db.DB;
import db.DbIntegrityException;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

//            int x = 1;
//            if (x < 2) {
//                throw new SQLException("Fake error");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
            conn.commit();

            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);
        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbIntegrityException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1) {
                throw new DbIntegrityException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
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

//  POST - Inserir dados
//          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//          Connection conn = null;
//          PreparedStatement st = null;
//
//          try {
//              conn = DB.getConnection();
//                  EXAMPLE 1
//              st = conn.prepareStatement(
//                      "INSERT INTO seller "
//                      + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
//                      + "VALUES "
//                      + "(?, ?, ?, ?, ?)",
//              Statement.RETURN_GENERATED_KEYS
//              );
//              st.setString(1, "Carl Purple");
//              st.setString(2, "carl@gmail.com");
//              st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
//              st.setDouble(4, 3000.0);
//              st.setInt(5, 4);
//
//                  EXAMPLE 2
//              st = conn.prepareStatement(
//                  "INSERT INTO department (Name) VALUES ('D1'), ('D2')",
//                  Statement.RETURN_GENERATED_KEYS
//               );
//
//               int rowsAffected = st.executeUpdate();
//
//               if (rowsAffected > 0) {
//                  ResultSet rs = st.getGeneratedKeys();
//                  while (rs.next()) {
//                      int id = rs.getInt(1);
//                      System.out.println("Done! ID = " + id);
//                  }
//                } else {
//                    System.out.println("No rown affected!");
//                }
//                }
//                catch (ParseException e) {
//                          e.printStackTrace();
//                }
//                catch (SQLException e) {
//                          e.printStackTrace();
//                }
//                finally {
//                DB.closeStatement(st);
//                DB.closeConnection();
//        }
//

//  UPDATE - Atualizar dados
//        Connection conn = null;
//        PreparedStatement st = null;
//
//        try {
//             conn = DB.getConnection();
//             st = conn.prepareStatement(
//                    "UPDATE seller "
//                    + "SET BaseSalary = BaseSalary = ?"
//                    + "WHERE "
//                    + "(DepartmentId = ?)");
//             st.setDouble(1, 200.0);
//             st.setInt(2, 2);
//
//             int rowsAffected = st.executeUpdate();
//             System.out.println("Done! Rows affected: " + rowsAffected);
//        }
//        catch (SQLException e) {
//              e.printStackTrace();
//        }
//        finally {
//            DB.closeStatement(st);
//            DB.closeConnection();
//        }

//  DELETE - Deletar dados
//       Connection conn = null;
//       PreparedStatement st = null;
//
//       try {
//           conn = DB.getConnection();
//           st = conn.prepareStatement(
//               "DELETE FROM department "
//                   + "WHERE "
//                   + "Id = ?");
//           st.setInt(1, 5);
//
//           int rowsAffected = st.executeUpdate();
//           System.out.println("Done! Rows affected: " + rowsAffected);
//       }
//       catch (SQLException e) {
//           throw new DbIntegrityException(e.getMessage());
//       }
//       finally {
//           DB.closeStatement(st);
//           DB.closeConnection();
//       }

