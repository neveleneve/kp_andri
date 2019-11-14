package configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class classFunction {

    public static void loginFunction(JTextField username, JPasswordField password) {
        try {
            Connection con = new classconnection().connection();
            String sqlUser = "select * from tb_login where username = '" + username.getText() + "'";
            Statement stUser = con.createStatement();
            ResultSet rsUser = stUser.executeQuery(sqlUser);
            if (rsUser.next()) {
                String sqlPass = "select * from tb_login where username = '" + username.getText() + "' and password = '"+password.getText()+"'";
                Statement stPass = con.createStatement();
                ResultSet rsPass = stPass.executeQuery(sqlPass);
                if (rsPass.next()) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang!!!", "Login Berhasil", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Password Anda Salah", "Login Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Login Tidak Ada", "Login Gagal", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error = " + e);
        }
    }
    
    
}
