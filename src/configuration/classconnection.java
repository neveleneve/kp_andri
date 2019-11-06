/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NEVE
 */
public class classconnection {
    public Connection koneksi;
    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Telah Dimasukkan");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Tidak Ditemukan");
        }
        try {
            String url = "jdbc:mysql://localhost:3306/DBpenggajianKP";
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Disconnected");
        }
        return koneksi;
    }
}
