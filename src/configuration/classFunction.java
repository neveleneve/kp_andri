package configuration;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
        tbMd.addColumn("Jabatan");
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
                    res.getString(3),
                    res.getString(2),
                    res.getString(4),
                    res.getString(5),
                    sdf.format(res.getDate(7)),
                    res.getString(6),
                    res.getString(8)
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
            tbl.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(300);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(120);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(0).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(1).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(2).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(3).setCellRenderer(midAligment);
            tbl.getColumnModel().getColumn(4).setCellRenderer(midAligment);
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
    public static void clearData(JTextField a, JTextField b, JTextField c, JTextField d, JXDatePicker e, JComboBox f, JComboBox g) {
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setDate(new Date());
        f.setSelectedIndex(0);
        g.setSelectedIndex(0);
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

    public static void clearReport(JComboBox a, JComboBox b, JComboBox c, JTextField d, JComboBox e) {
        e.setSelectedIndex(0);
        a.setSelectedIndex(0);
        b.setSelectedIndex(0);
        c.setSelectedIndex(0);
        d.setText("");
    }

//Control Form (Insert)//
    public static void insertDataPegawai(JLabel a, JComboBox h, JTextField b, JComboBox c, JTextField d, JTextField e, JXDatePicker f, JTextField g) {
        try {
            SQL = "insert into tb_karyawan values(?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = con.prepareStatement(SQL);
            try {
                stmt.setString(1, a.getText());
                stmt.setString(2, h.getSelectedItem().toString());
                stmt.setString(3, b.getText());
                stmt.setString(4, c.getSelectedItem().toString());
                stmt.setString(5, d.getText());
                stmt.setString(6, e.getText());
                stmt.setString(7, new SimpleDateFormat("yyyy-MM-dd").format(f.getDate()));
                stmt.setString(8, g.getText());
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

    public static void insertDataGaji(JTextField a, JTextField b, JTextField c) {
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

//Control Form (Edit)//
    public static void editDataPegawai(JTextField a, JComboBox b, JTextField c, JTextField d, JXDatePicker e, JTextField f, JLabel g, JComboBox h) {
        try {
            String sql = "update tb_karyawan set nama_karyawan = ?, jenis_kelamin = ?, alamat = ?, "
                    + "tempat_lahir = ?, tanggal_lahir = ?, no_hp = ?, jabatan = ? where id_karyawan = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a.getText());
            pst.setString(2, b.getSelectedItem().toString());
            pst.setString(3, c.getText());
            pst.setString(4, d.getText());
            pst.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(e.getDate()));
            pst.setString(6, f.getText());
            pst.setString(7, h.getSelectedItem().toString());
            pst.setString(8, g.getText());            
            pst.executeUpdate();
        } catch (SQLException i) {
            System.out.println(i);
        }
    }

    public static void editDataPenggajian(JComboBox a, JTextField b, JComboBox c, JTextField d, JComboBox e, JComboBox f, JLabel g) {
        try {
            String sql = "update tb_penggajian set id_karyawan = ?, nama = ?, jabatan = ?, "
                    + "total_gaji = ?, bulan = ?, tahun = ? where id_penggajian = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a.getSelectedItem().toString());
            pst.setString(2, b.getText());
            pst.setString(3, c.getSelectedItem().toString());
            pst.setString(4, d.getText());
            pst.setString(5, e.getSelectedItem().toString());
            pst.setString(6, f.getSelectedItem().toString());
            pst.setString(7, g.getText());
            pst.executeUpdate();
        } catch (SQLException h) {
            System.out.println(h);
        }
    }

    public static void editDataGaji(JTextField a, JTextField b, JTextField c) {
        try {
            String sql = "update tb_gaji set jabatan = ?, total_gaji = ? where id_gaji = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, a.getText());
            pst.setString(2, b.getText());
            pst.setString(3, c.getText());
            pst.executeUpdate();
        } catch (SQLException h) {
            System.out.println(h);
        }
    }

//Control Form (Delete)//
    public static void deleteDataPegawai(JLabel a) {
        try {
            String sql = "delete from tb_karyawan where id_karyawan = '" + a.getText() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteDataPenggajian(JLabel a) {
        try {
            String sql = "delete from tb_penggajian where id_penggajian = '" + a.getText() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteDataGaji(JTextField a) {
        try {
            String sql = "delete from tb_gaji where idgaji = '" + a.getText() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//Combo Change//
    public static void comboSelected(JComboBox a, JTextField b, String c, String d, String e) {
        try {
            SQL = "select " + c + " as jj from " + d + " where " + e + " = '" + a.getSelectedItem().toString() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                b.setText(rs.getString("jj"));
            }
        } catch (SQLException xx) {
            System.out.println(xx);
        }
    }

    public static void comboSelectedSpesial(String a, String b, 
            String c, String d, JComboBox e, JTextField f, 
            JComboBox g) {
        try {
            SQL = "select " + a + ", " + b + " from " + c + " where " + d + " = '" + e.getSelectedItem().toString() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                f.setText(rs.getString(a));
                g.setSelectedItem(rs.getString(b));
            }
        } catch (SQLException xx) {
            System.out.println(xx);
        }
    }

//Report//
    public static void reportingSlip(JComboBox a, JComboBox b, JComboBox c) {
        try {
            File file = new File("src/report/slip_gaji.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select * from tb_penggajian where id_karyawan = '" + a.getSelectedItem().toString() + "' and bulan = '" + b.getSelectedItem().toString() + "' and tahun = '" + c.getSelectedItem().toString() + "'";
            JRDesignQuery jrq = new JRDesignQuery();
//            Map<String, Object> parameters;
//            parameters = new HashMap<>();

            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void reportingBulanan(JComboBox a, JComboBox b, String c) {
        try {
            File file = new File("src/report/laporan_bulanan.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select * from tb_penggajian where bulan = '" + a.getSelectedItem().toString() + "' and tahun = '" + b.getSelectedItem().toString() + "' order by id_penggajian asc";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("bulantahun", c);
            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }
}
