package configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;

public class classFunction {

    public static DefaultTableModel tbMd = new DefaultTableModel();
    public static Connection con = new classconnection().connection();
    public static String SQL;
    static Locale id = new Locale("in", "ID");
    static String pattern = "dd MMMM yyyy";
    public static SimpleDateFormat sdf = new SimpleDateFormat(pattern, id);

//Login Funcition//    
    public static void loginFunction(JTextField username, JPasswordField password, JFrame a, JFrame b) {
        try {
            String nama;
            String sqlUser = "select * from tb_login where username = '" + username.getText() + "'";
            Statement stUser = con.createStatement();
            ResultSet rsUser = stUser.executeQuery(sqlUser);
            if (rsUser.next()) {
                String sqlPass = "select * from tb_login where username = '" + username.getText() + "' and password = '" + password.getText() + "'";
                Statement stPass = con.createStatement();
                ResultSet rsPass = stPass.executeQuery(sqlPass);
                if (rsPass.next()) {
                    nama = rsPass.getString(1);
                    JOptionPane.showMessageDialog(a, "Selamat Datang, " + nama + " !!!", "Login Berhasil", JOptionPane.INFORMATION_MESSAGE);
                    a.dispose();
                    b.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(a, "Password Anda Salah", "Login Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(a, "Data Login Tidak Ada", "Login Gagal", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error = " + e);
        }
    }

    public static void getAdminName(JTextField a, JPasswordField b, JLabel c) {

        try {
            SQL = "select * from tb_login where username = '" + a.getText() + "' and password = '" + b.getText() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c.setText(rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

//Tampil Data Function//
    public static void tampilDataPegawai(JTable tbl) {
        tbMd = new DefaultTableModel();
        tbMd.addColumn("ID Pegawai");
        tbMd.addColumn("Nama Pegawai");
        tbMd.addColumn("Jenis Kelamin");
        tbMd.addColumn("Alamat");
        tbMd.addColumn("Tempat Lahir");
        tbMd.addColumn("Tanggal Lahir");
        tbMd.addColumn("Kontak");
        tbl.setModel(tbMd);
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select * from tb_karyawan order by id_karyawan";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                tbMd.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    sdf.format(res.getDate(6)),
                    res.getString(7)
                });
            }

            DefaultTableCellRenderer midAligment = new DefaultTableCellRenderer();
            DefaultTableCellRenderer rightAligment = new DefaultTableCellRenderer();
            midAligment.setHorizontalAlignment(JLabel.CENTER);
            rightAligment.setHorizontalAlignment(JLabel.RIGHT);
            tbl.getColumnModel().getColumn(0).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(3).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(4).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(5).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(6).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(300);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(120);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(0).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(3).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(4).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(5).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(6).setCellRenderer(midAligment);
            tbl.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //tbl.getTableHeader().setReorderingAllowed(true);
            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tbl.setDefaultEditor(Object.class, null);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void tampilDataPenggajian(JTable tbl) {
        tbMd = new DefaultTableModel();
        tbMd.addColumn("ID Penggajian");
        tbMd.addColumn("ID Karyawan");
        tbMd.addColumn("Nama Karyawan");
        tbMd.addColumn("Jabatan");
        tbMd.addColumn("Total Gaji");
        tbMd.addColumn("Bulan");
        tbMd.addColumn("Tahun");
        tbMd.addColumn("Tanggal");
        tbl.setModel(tbMd);
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select * from tb_penggajian order by id_penggajian";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                tbMd.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    "Rp. " + NumberFormat.getInstance().format(Float.parseFloat(res.getString(5))).replace(",", ".") + ",00",
                    res.getString(6),
                    res.getString(7),
                    sdf.format(res.getDate(8))
                });
            }
            DefaultTableCellRenderer midAligment = new DefaultTableCellRenderer();
            DefaultTableCellRenderer rightAligment = new DefaultTableCellRenderer();
            midAligment.setHorizontalAlignment(JLabel.CENTER);
            rightAligment.setHorizontalAlignment(JLabel.RIGHT);
            tbl.getColumnModel().getColumn(0).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(3).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(4).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(5).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(6).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(7).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(120);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(120);
            tbl.getColumnModel().getColumn(0).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(3).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(4).setCellRenderer(rightAligment);
            tbl.getColumnModel().getColumn(5).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(6).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(7).setCellRenderer(midAligment);
            tbl.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //tbl.getTableHeader().setReorderingAllowed(true);
            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tbl.setDefaultEditor(Object.class, null);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void tampilDataGaji(JTable tbl) {
        tbMd = new DefaultTableModel();
        tbMd.addColumn("ID Gaji");
        tbMd.addColumn("Jabatan");
        tbMd.addColumn("Total Gaji");
        tbl.setModel(tbMd);
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select * from tb_gaji order by id_gaji";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                tbMd.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    "Rp. " + NumberFormat.getInstance().format(Float.parseFloat(res.getString(3))).replace(",", ".") + ",00"

                });
            }

            DefaultTableCellRenderer midAligment = new DefaultTableCellRenderer();
            DefaultTableCellRenderer rightAligment = new DefaultTableCellRenderer();
            midAligment.setHorizontalAlignment(JLabel.CENTER);
            rightAligment.setHorizontalAlignment(JLabel.RIGHT);
            tbl.getColumnModel().getColumn(0).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setHeaderRenderer(midAligment);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(0).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setCellRenderer(midAligment);
            tbl.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tbl.setDefaultEditor(Object.class, null);
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error" + e);
        }
    }

//Trace ID Baru//
    public static void idPegawaiBaru(JLabel a) {
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select max(right(id_karyawan, 4)) as jj from tb_karyawan";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                if (res.first() == false) {
                    a.setText("K0001");
                } else {
                    res.last();
                    int autoid = res.getInt("jj") + 1;
                    String nomor = String.valueOf(autoid);
                    int noLong = nomor.length();
                    for (int x = 0; x < 4 - noLong; x++) {
                        nomor = "0" + nomor;
                    }
                    a.setText("K" + nomor);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
    }

    public static void idPenggajianBaru(JLabel a) {
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select max(right(id_penggajian, 4)) as jj from tb_penggajian";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                if (res.first() == false) {
                    a.setText("P0001");
                } else {
                    res.last();
                    int autoid = res.getInt("jj") + 1;
                    String nomor = String.valueOf(autoid);
                    int noLong = nomor.length();
                    for (int x = 0; x < 4 - noLong; x++) {
                        nomor = "0" + nomor;
                    }
                    a.setText("P" + nomor);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
    }

    public static void idGajiBaru(JTextField a) {
        try {
            java.sql.Statement stmt = con.createStatement();
            SQL = "select max(right(id_gaji, 4)) as jj from tb_gaji";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                if (res.first() == false) {
                    a.setText("G0001");
                } else {
                    res.last();
                    int autoid = res.getInt("jj") + 1;
                    String nomor = String.valueOf(autoid);
                    int noLong = nomor.length();
                    for (int x = 0; x < 4 - noLong; x++) {
                        nomor = "0" + nomor;
                    }
                    a.setText("G" + nomor);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
    }

//Control Form (Clear)//
    public static void clearData(JTextField a, JTextField b, JTextField c, JTextField d, JXDatePicker e, JComboBox f) {
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setDate(new Date());
        f.setSelectedIndex(0);
    }

    public static void clearInput(JComboBox a, JComboBox b, JComboBox c, JComboBox d, JTextField e, JTextField f) {
        a.setSelectedIndex(0);
        b.setSelectedIndex(0);
        c.setSelectedIndex(0);
        d.setSelectedIndex(0);
        e.setText("");
        f.setText("");
    }

    public static void clearGaji(JTextField a, JTextField b, JTextField c) {
        a.setText("");
        b.setText("");
        c.setText("");
    }

    public static void clearReport(JComboBox a, JComboBox b, JComboBox c, JTextField d) {
        a.setSelectedIndex(0);
        b.setSelectedIndex(0);
        c.setSelectedIndex(0);
        d.setText("");
    }

//Control Form (Insert)//
    public static void insertDataPegawai(JLabel a, JTextField b, JComboBox c, JTextField d, JTextField e, JXDatePicker f, JTextField g) {
        try {
            SQL = "insert into tb_karyawan values(?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = con.prepareStatement(SQL);
            try {
                stmt.setString(1, a.getText());
                stmt.setString(2, b.getText());
                stmt.setString(3, c.getSelectedItem().toString());
                stmt.setString(4, d.getText());
                stmt.setString(5, e.getText());
                stmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(f.getDate()));
                stmt.setString(7, g.getText());
                stmt.executeUpdate();
            } catch (SQLException qq) {
                System.out.println(qq);
            }
        } catch (NumberFormatException | SQLException qq) {
            System.out.println(qq);
        }
    }

    public static void insertDataPenggajian(JLabel a, JComboBox b, JTextField c, JComboBox d, JTextField e, JComboBox f, JComboBox g, Date h) {
        try {
            SQL = "insert into tb_penggajian values(?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = con.prepareStatement(SQL);
            try {
                stmt.setString(1, a.getText());
                stmt.setString(2, b.getSelectedItem().toString());
                stmt.setString(3, c.getText());
                stmt.setString(4, d.getSelectedItem().toString());
                stmt.setString(5, e.getText());
                stmt.setString(6, f.getSelectedItem().toString());
                stmt.setString(7, g.getSelectedItem().toString());
                stmt.setString(8, new SimpleDateFormat("yyyy-MM-dd").format(h));
                stmt.executeUpdate();
            } catch (SQLException qq) {
                System.out.println(qq);
            }
        } catch (NumberFormatException | SQLException qq) {
            System.out.println(qq);
        }
    }

    public static void insertDataGaji(JTextField a, JTextField b, JTextField c){
        try {
            SQL = "insert into tb_gaji values(?,?,?)";
            java.sql.PreparedStatement stmt = con.prepareStatement(SQL);
            try {
                stmt.setString(1, a.getText());
                stmt.setString(2, b.getText());
                stmt.setString(3, c.getText());                
                stmt.executeUpdate();
            } catch (SQLException qq) {
                System.out.println(qq);
            }
        } catch (NumberFormatException | SQLException qq) {
            System.out.println(qq);
        }
    }
//Isi Combo//
    public static void comboJabatan(JComboBox cb) {
        try {
            SQL = "select * from tb_gaji";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                String kode = rs.getString("jabatan");
                cb.addItem(kode);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }

    public static void comboIDPegawai(JComboBox cb) {
        try {
            SQL = "select * from tb_karyawan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                String kode = rs.getString("id_karyawan");
                cb.addItem(kode);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
//Combo Change//
    public static void idSelected(JComboBox a, JTextField b) {
        try {
            SQL = "select nama_karyawan as jj from tb_karyawan where id_karyawan = '" + a.getSelectedItem().toString() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                b.setText(rs.getString("jj"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void jabatanSelected(JComboBox a, JTextField b) {
        try {
            SQL = "select total_gaji as jj from tb_gaji where jabatan = '" + a.getSelectedItem().toString() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                b.setText(rs.getString("jj"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
