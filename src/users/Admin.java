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
import javax.swing.JOptionPane;

/**
 *
 * @author ruhic
 */
public class Admin {

    Connection conn = DBConnectivity.getConnection();

    public void addUser(String firstName, String lastName, String email, String userName, String password, String jobTitle) throws SQLException {
        String insert = ("Insert into Staff (firstName, lastName, email, username, password, jobTitle) values (?, ? , ?, ?, ?, ?)");
        PreparedStatement pst = conn.prepareStatement(insert);

        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, email);
        pst.setString(4, userName);
        pst.setString(5, password);
        pst.setString(6, jobTitle);

        pst.execute();
        conn.close();
        JOptionPane.showMessageDialog(null, "Saved");
    }

    public void removeUser(String username) throws SQLException {
        String delete = ("DELETE from Staff where username=?");
        PreparedStatement pst = conn.prepareStatement(delete);

        pst.setString(1, username);

        pst.execute();
        conn.close();
        JOptionPane.showMessageDialog(null, "Deleted");
    }

    public void updateUser(String firstName, String surname, String email, String username, String password, String jobTitle, String oldUsername) throws SQLException {
        String update = ("UPDATE Staff set firstName = '" + firstName + "', lastName = '" + surname + "', email = '" + email + "', username = '" + username + "', password = '" + password + "', jobTitle = '" + jobTitle + "' where username = '" + oldUsername + "'");
        PreparedStatement pst = conn.prepareStatement(update);

        pst.setString(1, oldUsername);
        pst.setString(2, firstName);
        pst.setString(3, surname);
        pst.setString(4, email);
        pst.setString(5, username);
        pst.setString(6, password);
        pst.setString(7, jobTitle);

        pst.execute();
        conn.close();
        JOptionPane.showMessageDialog(null, "Updated");
    }
}
