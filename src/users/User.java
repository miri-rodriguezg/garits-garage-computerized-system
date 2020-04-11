/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import demrar.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ruhic
 */
public class User {

    Connection conn = DBConnectivity.getConnection();

    public boolean login(String userName, String pass) throws SQLException {

        String sql = ("select * from Staff where username=?, and password=?");
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, userName);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            conn.close();
            return true;
        } else {
            conn.close();
            return false;
        }

    }
}
