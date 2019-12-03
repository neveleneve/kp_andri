/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import configuration.classFunction;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NEVE
 */
public final class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     *
     * @param nama
     */
    //String namaAdmin;
    public Admin(String nama) {
        initComponents();
        classFunction.checkboxesSelectedSelectedState(cbJanuari, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
        lbWelcome.setText("Selamat Datang, " + nama + " !");
        lbnama.setText(nama);
        logo_.setText("");
        logo_CV();
        dtDataLahir.setFormats("dd MMMM yyyy");
        dtDataLahir.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dtDataLahir.setDate(new Date());
        //--------------------------------------------------------//
        classFunction.idPenggajianBaru(lbInputIdPenggajian);
        classFunction.idPegawaiBaru(lbDataNewIDPegawai);
        classFunction.idGajiBaru(txtGajiID);
        //--------------------------------------------------------//
        classFunction.tampilDataPegawai(tb_pegawai);
        classFunction.tampilDataPenggajian(tb_penggajian);
        classFunction.tampilDataGaji(tb_gaji);
        //--------------------------------------------------------//
        classFunction.comboJabatan(cbInputJabatan);
        classFunction.comboJabatan(cbDataJabatan);
        classFunction.comboIDPegawai(cbInputGajiID);
        classFunction.comboIDPegawai(cbReportIDKaryawan);
        //--------------------------------------------------------//
        txtReportNama.setEnabled(false);
        cbReportIDKaryawan.setEnabled(false);
//        cbReportBulan.setEnabled(false);
        disableBulanCheckbox();
        cbReportTahun.setEnabled(false);
        lbInputIdPenggajian.setVisible(false);
        lbDataNewIDPegawai.setVisible(false);
        lbnama.setVisible(false);
        //--------------------------------------------------------//
        btDataDelete.setEnabled(false);
        btDataEdit.setEnabled(false);
        btInputDelete.setEnabled(false);
        btInputEdit.setEnabled(false);
        btGajiDelete.setEnabled(false);
        btGajiEdit.setEnabled(false);
    }

    void logo_CV() {
        ImageIcon myimg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        Image img1 = myimg.getImage();
        Image img2 = img1.getScaledInstance(logo_.getWidth() - 300, logo_.getHeight() - 70, Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        logo_.setIcon(i);
    }

    void disableBulanCheckbox() {
        cbJanuari.setEnabled(false);
        cbFebruari.setEnabled(false);
        cbMaret.setEnabled(false);
        cbApril.setEnabled(false);
        cbMei.setEnabled(false);
        cbJuni.setEnabled(false);
        cbJuli.setEnabled(false);
        cbAgustus.setEnabled(false);
        cbSeptember.setEnabled(false);
        cbOktober.setEnabled(false);
        cbNovember.setEnabled(false);
        cbDesember.setEnabled(false);
    }

    void enableBulanCheckbox() {
        cbJanuari.setEnabled(true);
        cbFebruari.setEnabled(true);
        cbMaret.setEnabled(true);
        cbApril.setEnabled(true);
        cbMei.setEnabled(true);
        cbJuni.setEnabled(true);
        cbJuli.setEnabled(true);
        cbAgustus.setEnabled(true);
        cbSeptember.setEnabled(true);
        cbOktober.setEnabled(true);
        cbNovember.setEnabled(true);
        cbDesember.setEnabled(true);
    }

    void deselectBulanCheckbox() {
        cbJanuari.setSelected(false);
        cbFebruari.setSelected(false);
        cbMaret.setSelected(false);
        cbApril.setSelected(false);
        cbMei.setSelected(false);
        cbJuni.setSelected(false);
        cbJuli.setSelected(false);
        cbAgustus.setSelected(false);
        cbSeptember.setSelected(false);
        cbOktober.setSelected(false);
        cbNovember.setSelected(false);
        cbDesember.setSelected(false);
    }

    public void checkboxStatArray() {
        String a, b, c, d, e, f, g, h, i, j, k, l;
        if (cbJanuari.isSelected()) {
            a = "'" + cbJanuari.getText() + "'";
        } else {
            a = "";
        }
        if (cbFebruari.isSelected()) {
            b = "'" + cbFebruari.getText() + "'";
        } else {
            b = "";
        }
        if (cbMaret.isSelected()) {
            c = "'" + cbMaret.getText() + "'";
        } else {
            c = "";
        }
        if (cbApril.isSelected()) {
            d = "'" + cbApril.getText() + "'";
        } else {
            d = "";
        }
        if (cbMei.isSelected()) {
            e = "'" + cbMei.getText() + "'";
        } else {
            e = "";
        }
        if (cbJuni.isSelected()) {
            f = "'" + cbJuni.getText() + "'";
        } else {
            f = "";
        }
        if (cbJuli.isSelected()) {
            g = "'" + cbJuli.getText() + "'";
        } else {
            g = "";
        }
        if (cbAgustus.isSelected()) {
            h = "'" + cbAgustus.getText() + "'";
        } else {
            h = "";
        }
        if (cbSeptember.isSelected()) {
            i = "'" + cbSeptember.getText() + "'";
        } else {
            i = "";
        }
        if (cbOktober.isSelected()) {
            j = "'" + cbOktober.getText() + "'";
        } else {
            j = "";
        }
        if (cbNovember.isSelected()) {
            k = "'" + cbNovember.getText() + "'";
        } else {
            k = "";
        }
        if (cbDesember.isSelected()) {
            l = "'" + cbDesember.getText() + "'";
        } else {
            l = "";
        }
        String[] m = {a, b, c, d, e, f, g, h, i, j, k, l};
        String n = Arrays.toString(m).replace("[", "( ").replace(", ]", ")").replace(" ,", "").replace("( ", "(").replace(", )", ")");
        System.out.println();
        query = n;
    }

    String query;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        logo_ = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pegawai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDataNamaKaryawan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataHP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbDataKelamin = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dtDataLahir = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        txtDataLahir = new javax.swing.JTextField();
        btDataDelete = new javax.swing.JButton();
        btDataAddNew = new javax.swing.JButton();
        btDataSave = new javax.swing.JButton();
        btDataEdit = new javax.swing.JButton();
        lbDataNewIDPegawai = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbDataJabatan = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_penggajian = new javax.swing.JTable();
        cbInputGajiID = new javax.swing.JComboBox<>();
        txtInputNama = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbInputJabatan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbInputBulan = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbInputTahun = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtInputTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btInputAddNew = new javax.swing.JButton();
        btInputSave = new javax.swing.JButton();
        btInputEdit = new javax.swing.JButton();
        btInputDelete = new javax.swing.JButton();
        lbInputIdPenggajian = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_gaji = new javax.swing.JTable();
        txtGajiID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btGajiAddNew = new javax.swing.JButton();
        btGajiSave = new javax.swing.JButton();
        btGajiEdit = new javax.swing.JButton();
        btGajiDelete = new javax.swing.JButton();
        txtGajiJabatan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGajiTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cbReportIDKaryawan = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtReportNama = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbReportTahun = new javax.swing.JComboBox<>();
        btReportCetak = new javax.swing.JButton();
        btReportAddNew = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbReportSelect = new javax.swing.JComboBox<>();
        cbJuni = new javax.swing.JCheckBox();
        cbJanuari = new javax.swing.JCheckBox();
        cbFebruari = new javax.swing.JCheckBox();
        cbMaret = new javax.swing.JCheckBox();
        cbApril = new javax.swing.JCheckBox();
        cbMei = new javax.swing.JCheckBox();
        cbDesember = new javax.swing.JCheckBox();
        cbNovember = new javax.swing.JCheckBox();
        cbOktober = new javax.swing.JCheckBox();
        cbSeptember = new javax.swing.JCheckBox();
        cbAgustus = new javax.swing.JCheckBox();
        cbJuli = new javax.swing.JCheckBox();
        lbWelcome = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbnama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo_.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        logo_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo_.setText("LOGO");
        jPanel1.add(logo_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 890, 370));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("CV. MEGAH KARYA");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 890, 90));

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pegawai);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 875, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Jabatan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 120, 30));

        txtDataNamaKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtDataNamaKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 160, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Alamat");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, 30));

        txtDataAlamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtDataAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("No. Handphone");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 120, 30));

        txtDataHP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtDataHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 120, 30));

        cbDataKelamin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDataKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelamin...", "Pria", "Wanita" }));
        jPanel2.add(cbDataKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tanggal Lahir");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 120, 30));
        jPanel2.add(dtDataLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 160, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tempat Lahir");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 120, 30));

        txtDataLahir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtDataLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 160, 30));

        btDataDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDataDelete.setText("Delete");
        btDataDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btDataDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 100, 40));

        btDataAddNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDataAddNew.setText("Add New");
        btDataAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataAddNewActionPerformed(evt);
            }
        });
        jPanel2.add(btDataAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 100, 40));

        btDataSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDataSave.setText("Save");
        btDataSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btDataSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 40));

        btDataEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDataEdit.setText("Edit");
        btDataEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDataEditActionPerformed(evt);
            }
        });
        jPanel2.add(btDataEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 100, 40));

        lbDataNewIDPegawai.setText("jLabel17");
        jPanel2.add(lbDataNewIDPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Nama");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 120, 30));

        cbDataJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jabatan..." }));
        jPanel2.add(cbDataJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 160, 30));

        jTabbedPane1.addTab("Data Pegawai", jPanel2);

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_penggajian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_penggajian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_penggajianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_penggajian);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 875, 260));

        cbInputGajiID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbInputGajiID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Pegawai..." }));
        cbInputGajiID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbInputGajiIDItemStateChanged(evt);
            }
        });
        jPanel4.add(cbInputGajiID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 160, 30));

        txtInputNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(txtInputNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Nama Pegawai");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ID Pegawai");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 120, 30));

        cbInputJabatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbInputJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jabatan..." }));
        cbInputJabatan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbInputJabatanItemStateChanged(evt);
            }
        });
        jPanel4.add(cbInputJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Jabatan");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 120, 30));

        cbInputBulan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbInputBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Bulan...", "Januari", "Februari", "Maret", "April", "Maret", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jPanel4.add(cbInputBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 160, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Bulan");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 120, 30));

        cbInputTahun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbInputTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun...", "2018", "2019", "2020", "2021", "2022", "2023" }));
        jPanel4.add(cbInputTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 160, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tahun");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 120, 30));

        txtInputTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(txtInputTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 160, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Total Gaji");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 120, 30));

        btInputAddNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInputAddNew.setText("Add New");
        btInputAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputAddNewActionPerformed(evt);
            }
        });
        jPanel4.add(btInputAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 100, 40));

        btInputSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInputSave.setText("Save");
        btInputSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputSaveActionPerformed(evt);
            }
        });
        jPanel4.add(btInputSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 40));

        btInputEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInputEdit.setText("Edit");
        btInputEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputEditActionPerformed(evt);
            }
        });
        jPanel4.add(btInputEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 100, 40));

        btInputDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btInputDelete.setText("Delete");
        btInputDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btInputDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 100, 40));

        lbInputIdPenggajian.setText("jLabel17");
        jPanel4.add(lbInputIdPenggajian, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jTabbedPane1.addTab("Input Penggajian", jPanel4);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_gaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_gaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_gajiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_gaji);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 305, 240));

        txtGajiID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGajiID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtGajiID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID Gaji");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 140, 30));

        btGajiAddNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGajiAddNew.setText("Add New");
        btGajiAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGajiAddNewActionPerformed(evt);
            }
        });
        jPanel3.add(btGajiAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 100, 40));

        btGajiSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGajiSave.setText("Save");
        btGajiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGajiSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btGajiSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 100, 40));

        btGajiEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGajiEdit.setText("Edit");
        btGajiEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGajiEditActionPerformed(evt);
            }
        });
        jPanel3.add(btGajiEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 100, 40));

        btGajiDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btGajiDelete.setText("Delete");
        btGajiDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGajiDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btGajiDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 100, 40));

        txtGajiJabatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGajiJabatan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtGajiJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Jabatan");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 140, 30));

        txtGajiTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGajiTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(txtGajiTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 100, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Rp.");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 40, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Total Gaji");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 140, 30));

        jTabbedPane1.addTab("Data Gaji", jPanel3);

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Jenis Laporan");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, 30));

        cbReportIDKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbReportIDKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Pegawai..." }));
        cbReportIDKaryawan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbReportIDKaryawanItemStateChanged(evt);
            }
        });
        jPanel5.add(cbReportIDKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 160, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Bulan");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 120, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Nama Pegawai");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 120, 30));

        txtReportNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txtReportNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 160, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Tahun");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 120, 30));

        cbReportTahun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbReportTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun...", "2018", "2019", "2020", "2021", "2022", "2023" }));
        jPanel5.add(cbReportTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 160, 30));

        btReportCetak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btReportCetak.setText("Cetak");
        btReportCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportCetakActionPerformed(evt);
            }
        });
        jPanel5.add(btReportCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 100, 40));

        btReportAddNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btReportAddNew.setText("Add New");
        btReportAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportAddNewActionPerformed(evt);
            }
        });
        jPanel5.add(btReportAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 100, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("ID Pegawai");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, 30));

        cbReportSelect.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbReportSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Laporan...", "Slip Gaji", "Laporan Bulanan" }));
        cbReportSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbReportSelectItemStateChanged(evt);
            }
        });
        jPanel5.add(cbReportSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 160, 30));

        cbJuni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbJuni.setText("Juni");
        cbJuni.setOpaque(false);
        cbJuni.setRequestFocusEnabled(false);
        cbJuni.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJuniItemStateChanged(evt);
            }
        });
        jPanel5.add(cbJuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        cbJanuari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbJanuari.setText("Januari");
        cbJanuari.setOpaque(false);
        cbJanuari.setRequestFocusEnabled(false);
        cbJanuari.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJanuariItemStateChanged(evt);
            }
        });
        jPanel5.add(cbJanuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        cbFebruari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbFebruari.setText("Februari");
        cbFebruari.setOpaque(false);
        cbFebruari.setRequestFocusEnabled(false);
        cbFebruari.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFebruariItemStateChanged(evt);
            }
        });
        jPanel5.add(cbFebruari, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        cbMaret.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbMaret.setText("Maret");
        cbMaret.setOpaque(false);
        cbMaret.setRequestFocusEnabled(false);
        cbMaret.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaretItemStateChanged(evt);
            }
        });
        jPanel5.add(cbMaret, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        cbApril.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbApril.setText("April");
        cbApril.setOpaque(false);
        cbApril.setRequestFocusEnabled(false);
        cbApril.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAprilItemStateChanged(evt);
            }
        });
        jPanel5.add(cbApril, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        cbMei.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbMei.setText("Mei");
        cbMei.setOpaque(false);
        cbMei.setRequestFocusEnabled(false);
        cbMei.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMeiItemStateChanged(evt);
            }
        });
        jPanel5.add(cbMei, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        cbDesember.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbDesember.setText("Desember");
        cbDesember.setOpaque(false);
        cbDesember.setRequestFocusEnabled(false);
        cbDesember.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDesemberItemStateChanged(evt);
            }
        });
        jPanel5.add(cbDesember, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, -1, -1));

        cbNovember.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbNovember.setText("November");
        cbNovember.setOpaque(false);
        cbNovember.setRequestFocusEnabled(false);
        cbNovember.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNovemberItemStateChanged(evt);
            }
        });
        jPanel5.add(cbNovember, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, -1, -1));

        cbOktober.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbOktober.setText("Oktober");
        cbOktober.setOpaque(false);
        cbOktober.setRequestFocusEnabled(false);
        cbOktober.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOktoberItemStateChanged(evt);
            }
        });
        jPanel5.add(cbOktober, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, -1));

        cbSeptember.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbSeptember.setText("September");
        cbSeptember.setOpaque(false);
        cbSeptember.setRequestFocusEnabled(false);
        cbSeptember.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSeptemberItemStateChanged(evt);
            }
        });
        jPanel5.add(cbSeptember, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        cbAgustus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbAgustus.setText("Agustus");
        cbAgustus.setOpaque(false);
        cbAgustus.setRequestFocusEnabled(false);
        cbAgustus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAgustusItemStateChanged(evt);
            }
        });
        jPanel5.add(cbAgustus, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));

        cbJuli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbJuli.setText("Juli");
        cbJuli.setOpaque(false);
        cbJuli.setRequestFocusEnabled(false);
        cbJuli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJuliItemStateChanged(evt);
            }
        });
        jPanel5.add(cbJuli, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

        jTabbedPane1.addTab("Laporan", jPanel5);

        jPanel6.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 550));

        lbWelcome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbWelcome.setText("Selamat Datang, Bambang!");
        jPanel6.add(lbWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 20));

        lbLogOut.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbLogOut.setForeground(new java.awt.Color(102, 102, 255));
        lbLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogOut.setText("Log Out");
        lbLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
        });
        jPanel6.add(lbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 100, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 100, 40));

        lbnama.setText("jLabel17");
        jPanel6.add(lbnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btDataEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataEditActionPerformed
        if (dtDataLahir.getDate().equals(new Date()) || txtDataNamaKaryawan.getText().equals("") || txtDataAlamat.getText().equals("") || cbDataJabatan.getSelectedIndex() == 0 || cbDataKelamin.getSelectedIndex() == 0 || txtDataLahir.getText().equals("") || txtDataHP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Edit Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Edit Pegawai Dengan ID " + lbDataNewIDPegawai.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.editDataPegawai(txtDataNamaKaryawan, cbDataKelamin, txtDataAlamat, txtDataLahir, dtDataLahir, txtDataHP, lbDataNewIDPegawai, cbDataJabatan);
                classFunction.tampilDataPegawai(tb_pegawai);
                classFunction.clearData(txtDataNamaKaryawan, txtDataAlamat, txtDataLahir, txtDataHP, dtDataLahir, cbDataKelamin, cbDataJabatan);
                classFunction.idPegawaiBaru(lbDataNewIDPegawai);
                btDataSave.setEnabled(true);
                btDataEdit.setEnabled(false);
                btDataDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Edit Data Pegawai Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btDataEditActionPerformed

    private void btDataDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataDeleteActionPerformed
        if (dtDataLahir.getDate().equals(new Date()) || txtDataNamaKaryawan.getText().equals("") || txtDataAlamat.getText().equals("") || cbDataJabatan.getSelectedIndex() == 0 || cbDataKelamin.getSelectedIndex() == 0 || txtDataLahir.getText().equals("") || txtDataHP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Hapus Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Hapus Data Penggajian Dengan ID " + lbDataNewIDPegawai.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.deleteDataPegawai(lbDataNewIDPegawai);
                classFunction.tampilDataPegawai(tb_pegawai);
                classFunction.clearData(txtDataNamaKaryawan, txtDataAlamat, txtDataLahir, txtDataHP, dtDataLahir, cbDataKelamin, cbDataJabatan);
                classFunction.idPegawaiBaru(lbDataNewIDPegawai);
                btDataSave.setEnabled(true);
                btDataEdit.setEnabled(false);
                btDataDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Hapus Penggajian Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btDataDeleteActionPerformed

    private void btGajiEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGajiEditActionPerformed
        if (txtGajiID.getText().equals("") || txtGajiJabatan.getText().equals("") || txtGajiTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Edit Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Edit Data Gaji Dengan ID " + txtGajiID.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.editDataGaji(txtGajiJabatan, txtGajiTotal, txtGajiID);
                classFunction.tampilDataGaji(tb_gaji);
                classFunction.clearGaji(txtGajiID, txtGajiJabatan, txtGajiTotal);
                classFunction.idGajiBaru(txtGajiID);
                btGajiSave.setEnabled(true);
                btGajiEdit.setEnabled(false);
                btGajiDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Edit Data Gaji Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btGajiEditActionPerformed

    private void btGajiDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGajiDeleteActionPerformed
        if (txtGajiID.getText().equals("") || txtGajiJabatan.getText().equals("") || txtGajiTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Delete Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Delete Data Gaji Dengan ID " + txtGajiID.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.deleteDataGaji(txtGajiID);
                classFunction.tampilDataGaji(tb_gaji);
                classFunction.clearGaji(txtGajiID, txtGajiJabatan, txtGajiTotal);
                classFunction.idGajiBaru(txtGajiID);
                btGajiSave.setEnabled(true);
                btGajiEdit.setEnabled(false);
                btGajiDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Delete Data Gaji Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btGajiDeleteActionPerformed

    private void btInputEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputEditActionPerformed
        if (txtInputNama.getText().equals("") || txtInputTotal.getText().equals("") || cbInputBulan.getSelectedIndex() == 0 || cbInputGajiID.getSelectedIndex() == 0 || cbInputJabatan.getSelectedIndex() == 0 || cbInputTahun.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Edit Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Edit Data Penggajian Dengan ID " + lbInputIdPenggajian.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.editDataPenggajian(cbInputGajiID, txtInputNama, cbInputJabatan, txtInputTotal, cbInputBulan, cbInputTahun, lbInputIdPenggajian);
                classFunction.tampilDataPenggajian(tb_penggajian);
                classFunction.clearInput(cbInputBulan, cbInputGajiID, cbInputJabatan, cbInputTahun, txtInputNama, txtInputTotal);
                classFunction.idPenggajianBaru(lbInputIdPenggajian);
                btInputSave.setEnabled(true);
                btInputEdit.setEnabled(false);
                btInputDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Edit Penggajian Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btInputEditActionPerformed

    private void btInputDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputDeleteActionPerformed
        if (txtInputNama.getText().equals("") || txtInputTotal.getText().equals("") || cbInputBulan.getSelectedIndex() == 0 || cbInputGajiID.getSelectedIndex() == 0 || cbInputJabatan.getSelectedIndex() == 0 || cbInputTahun.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Tekan Tabel Untuk Edit Data", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Edit Data Penggajian Dengan ID " + lbInputIdPenggajian.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.deleteDataPenggajian(lbInputIdPenggajian);
                classFunction.tampilDataPenggajian(tb_penggajian);
                classFunction.clearInput(cbInputBulan, cbInputGajiID, cbInputJabatan, cbInputTahun, txtInputNama, txtInputTotal);
                classFunction.idPenggajianBaru(lbInputIdPenggajian);
                btInputSave.setEnabled(true);
                btInputEdit.setEnabled(false);
                btInputDelete.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Edit Penggajian Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btInputDeleteActionPerformed

    private void btReportCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportCetakActionPerformed
        checkboxStatArray();
        System.out.println(query);
        if (classFunction.cb1 == false || classFunction.cb2 == false || classFunction.cb3 == false || classFunction.cb4 == false || classFunction.cb5 == false || classFunction.cb6 == false || classFunction.cb7 == false || classFunction.cb8 == false || classFunction.cb9 == false || classFunction.cb10 == false || classFunction.cb11 == false || classFunction.cb12 == false) {
            //JOptionPane.showMessageDialog(null, "Bulan Sudah Dipilih", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            switch (cbReportSelect.getSelectedIndex()) {
                case 0:
                    JOptionPane.showMessageDialog(this, "Silahkan Pilih Jenis Laporan Yang Akan Dicetak", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    if (cbReportIDKaryawan.getSelectedIndex() == 0 || cbReportTahun.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Pegawai Untuk Dicetak", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    } else {
                        classFunction.reportingSlip(cbReportIDKaryawan, query, cbReportTahun);
                    }
                    break;
                case 2:
                    if (cbReportTahun.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Laporan Yang Akan Dicetak", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    } else {
                        classFunction.reportingBulanan(query, cbReportTahun);
                    }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bulan Belum Dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btReportCetakActionPerformed

    private void btReportAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportAddNewActionPerformed
//        classFunction.clearReport(cbReportBulan, cbReportIDKaryawan, cbReportTahun, txtReportNama, cbReportSelect);
        checkboxStatArray();
    }//GEN-LAST:event_btReportAddNewActionPerformed

    private void btDataAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataAddNewActionPerformed
        classFunction.clearData(txtDataNamaKaryawan, txtDataAlamat, txtDataLahir, txtDataHP, dtDataLahir, cbDataKelamin, cbDataJabatan);
        classFunction.idPegawaiBaru(lbDataNewIDPegawai);
        btDataSave.setEnabled(true);
        btDataEdit.setEnabled(false);
        btDataDelete.setEnabled(false);
    }//GEN-LAST:event_btDataAddNewActionPerformed

    private void btInputAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputAddNewActionPerformed
        classFunction.clearInput(cbInputBulan, cbInputGajiID, cbInputJabatan, cbInputTahun, txtInputNama, txtInputTotal);
        classFunction.idPenggajianBaru(lbInputIdPenggajian);
        btInputSave.setEnabled(true);
        btInputEdit.setEnabled(false);
        btInputDelete.setEnabled(false);
    }//GEN-LAST:event_btInputAddNewActionPerformed

    private void btGajiAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGajiAddNewActionPerformed
        classFunction.clearGaji(txtGajiID, txtGajiJabatan, txtGajiTotal);
        classFunction.idGajiBaru(txtGajiID);
        btGajiSave.setEnabled(true);
        btGajiEdit.setEnabled(false);
        btGajiDelete.setEnabled(false);
    }//GEN-LAST:event_btGajiAddNewActionPerformed

    private void btDataSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDataSaveActionPerformed
        if (dtDataLahir.getDate().equals(new Date()) || txtDataNamaKaryawan.getText().equals("") || txtDataAlamat.getText().equals("") || cbDataJabatan.getSelectedIndex() == 0 || cbDataKelamin.getSelectedIndex() == 0 || txtDataLahir.getText().equals("") || txtDataHP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data Pegawai", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Tambahkan Pegawai Dengan ID " + lbDataNewIDPegawai.getText() + " Atas Nama " + txtDataNamaKaryawan.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.insertDataPegawai(lbDataNewIDPegawai, cbDataJabatan, txtDataNamaKaryawan, cbDataKelamin, txtDataAlamat, txtDataLahir, dtDataLahir, txtDataHP);
                classFunction.idPegawaiBaru(lbInputIdPenggajian);
                classFunction.tampilDataPegawai(tb_pegawai);
                classFunction.clearData(txtDataNamaKaryawan, txtDataAlamat, txtDataLahir, txtDataHP, dtDataLahir, cbInputBulan, cbDataJabatan);
                JOptionPane.showMessageDialog(this, "Input Data Pegawai Berhasil", "Berhasil!", JOptionPane.WARNING_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btDataSaveActionPerformed

    private void btInputSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputSaveActionPerformed
        if (txtInputNama.getText().equals("") || txtInputTotal.getText().equals("") || cbInputBulan.getSelectedIndex() == 0 || cbInputGajiID.getSelectedIndex() == 0 || cbInputJabatan.getSelectedIndex() == 0 || cbInputTahun.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data Penggajian", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Tambahkan Data Penggajian Dengan ID " + lbInputIdPenggajian.getText() + " Untuk Karyawan " + txtInputNama.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.insertDataPenggajian(lbInputIdPenggajian, cbInputGajiID, txtInputNama, cbInputJabatan, txtInputTotal, cbInputBulan, cbInputTahun, new Date());
                classFunction.idPenggajianBaru(lbDataNewIDPegawai);
                classFunction.tampilDataPenggajian(tb_penggajian);
                classFunction.clearInput(cbInputBulan, cbInputGajiID, cbInputJabatan, cbInputTahun, txtInputNama, txtInputTotal);
                JOptionPane.showMessageDialog(this, "Input Data Penggajian Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btInputSaveActionPerformed

    private void cbInputGajiIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbInputGajiIDItemStateChanged
        if (cbInputGajiID.getSelectedIndex() == 0) {
            cbInputBulan.setSelectedIndex(0);
            cbInputJabatan.setSelectedIndex(0);
            cbInputTahun.setSelectedIndex(0);
            txtInputNama.setText("");
            //txtInputTotal.setText("");
        } else {
            classFunction.comboSelectedSpesial("nama_karyawan", "jabatan",
                    "tb_karyawan", "id_karyawan", cbInputGajiID, txtInputNama,
                    cbInputJabatan);
            //classFunction.comboSelected(cbInputGajiID, txtInputNama, "nama_karyawan", "tb_karyawan", "id_karyawan");
        }
    }//GEN-LAST:event_cbInputGajiIDItemStateChanged

    private void cbReportIDKaryawanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbReportIDKaryawanItemStateChanged
        if (cbReportIDKaryawan.getSelectedIndex() == 0) {
            txtReportNama.setText("");
        } else {
            classFunction.comboSelected(cbReportIDKaryawan, txtReportNama, "nama_karyawan", "tb_karyawan", "id_karyawan");
        }
    }//GEN-LAST:event_cbReportIDKaryawanItemStateChanged

    private void cbInputJabatanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbInputJabatanItemStateChanged
        if (cbInputJabatan.getSelectedIndex() == 0) {
            txtInputTotal.setText("");
        } else {
            classFunction.comboSelected(cbInputJabatan, txtInputTotal, "total_gaji", "tb_gaji", "jabatan");
        }
    }//GEN-LAST:event_cbInputJabatanItemStateChanged

    private void btGajiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGajiSaveActionPerformed
        if (txtGajiID.getText().equals("") || txtGajiJabatan.getText().equals("") || txtGajiTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data Gaji", "Kesalahan!", JOptionPane.WARNING_MESSAGE);
        } else {
            int abcd = JOptionPane.showConfirmDialog(null, "Tambahkan Data Gaji Dengan ID " + lbInputIdPenggajian.getText() + " Untuk Karyawan " + txtInputNama.getText() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (abcd == JOptionPane.YES_OPTION) {
                classFunction.insertDataGaji(txtGajiID, txtGajiJabatan, txtGajiTotal);
                classFunction.idGajiBaru(txtGajiID);
                classFunction.tampilDataGaji(tb_gaji);
                classFunction.clearGaji(txtGajiID, txtGajiJabatan, txtGajiTotal);
                JOptionPane.showMessageDialog(this, "Input Data Gaji Berhasil", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        }
    }//GEN-LAST:event_btGajiSaveActionPerformed

    private void tb_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pegawaiMouseClicked
        int s = tb_pegawai.getSelectedRow();
        Date d = null;
        Locale id = new Locale("in", "ID");
        try {
            d = new SimpleDateFormat("dd MMMM yyyy", id).parse(tb_pegawai.getValueAt(s, 5).toString());
            dtDataLahir.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbDataNewIDPegawai.setText(tb_pegawai.getValueAt(s, 0).toString());
        txtDataNamaKaryawan.setText(tb_pegawai.getValueAt(s, 1).toString());
        cbDataJabatan.setSelectedItem(tb_pegawai.getValueAt(s, 2).toString());
        cbDataKelamin.setSelectedItem(tb_pegawai.getValueAt(s, 3).toString());
        txtDataAlamat.setText(tb_pegawai.getValueAt(s, 4).toString());
        txtDataLahir.setText(tb_pegawai.getValueAt(s, 6).toString());
        txtDataHP.setText(tb_pegawai.getValueAt(s, 7).toString());
        btDataSave.setEnabled(false);
        btDataDelete.setEnabled(true);
        btDataEdit.setEnabled(true);
    }//GEN-LAST:event_tb_pegawaiMouseClicked

    private void tb_penggajianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_penggajianMouseClicked
        int s = tb_penggajian.getSelectedRow();

        lbInputIdPenggajian.setText(tb_penggajian.getValueAt(s, 0).toString());
        cbInputGajiID.setSelectedItem(tb_penggajian.getValueAt(s, 1).toString());
        cbInputJabatan.setSelectedItem(tb_penggajian.getValueAt(s, 3).toString());
        cbInputBulan.setSelectedItem(tb_penggajian.getValueAt(s, 5).toString());
        cbInputTahun.setSelectedItem(tb_penggajian.getValueAt(s, 6).toString());
        btInputSave.setEnabled(false);
        btInputEdit.setEnabled(true);
        btInputDelete.setEnabled(true);
    }//GEN-LAST:event_tb_penggajianMouseClicked

    private void tb_gajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_gajiMouseClicked
        int s = tb_gaji.getSelectedRow();

        txtGajiID.setText(tb_gaji.getValueAt(s, 0).toString());
        txtGajiJabatan.setText(tb_gaji.getValueAt(s, 1).toString());
        txtGajiTotal.setText(tb_gaji.getValueAt(s, 2).toString().replace("Rp. ", "").replace(".", "").replace(",", ""));
        btGajiSave.setEnabled(false);
        btGajiEdit.setEnabled(true);
        btGajiDelete.setEnabled(true);
    }//GEN-LAST:event_tb_gajiMouseClicked

    private void cbReportSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbReportSelectItemStateChanged
        switch (cbReportSelect.getSelectedIndex()) {
            case 0:
                cbReportIDKaryawan.setEnabled(false);
                cbReportIDKaryawan.setSelectedIndex(0);
                disableBulanCheckbox();
                deselectBulanCheckbox();
                cbReportTahun.setEnabled(false);
                cbReportTahun.setSelectedIndex(0);
                txtReportNama.setEnabled(false);
                txtReportNama.setText("");
                break;
            case 1:
                cbReportIDKaryawan.setEnabled(true);
                cbReportIDKaryawan.setSelectedIndex(0);
                enableBulanCheckbox();
                deselectBulanCheckbox();
                cbReportTahun.setEnabled(true);
                cbReportTahun.setSelectedIndex(0);
                txtReportNama.setEnabled(true);
                txtReportNama.setText("");
                break;
            case 2:
                cbReportIDKaryawan.setEnabled(false);
                cbReportIDKaryawan.setSelectedIndex(0);
                enableBulanCheckbox();
                deselectBulanCheckbox();
                cbReportTahun.setEnabled(true);
                cbReportTahun.setSelectedIndex(0);
                txtReportNama.setEnabled(false);
                txtReportNama.setText("");
                break;
        }
    }//GEN-LAST:event_cbReportSelectItemStateChanged

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        int abcd = JOptionPane.showConfirmDialog(null, "Anda Akan Log Out. Lanjutkan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (abcd == JOptionPane.YES_OPTION) {
            this.dispose();
            new login().setVisible(true);
        } else {

        }
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Admin(lbnama.getText()).setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbJanuariItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJanuariItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbJanuari, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbJanuariItemStateChanged

    private void cbFebruariItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFebruariItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbFebruari, cbJanuari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbFebruariItemStateChanged

    private void cbMaretItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaretItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbMaret, cbFebruari, cbJanuari, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbMaretItemStateChanged

    private void cbAprilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAprilItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbApril, cbFebruari, cbMaret, cbJanuari, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbAprilItemStateChanged

    private void cbMeiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMeiItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbMei, cbFebruari, cbMaret, cbApril, cbJanuari, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbMeiItemStateChanged

    private void cbJuniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJuniItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbJuni, cbFebruari, cbMaret, cbApril, cbMei, cbJanuari, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbJuniItemStateChanged

    private void cbJuliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJuliItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbJuli, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJanuari, cbAgustus, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbJuliItemStateChanged

    private void cbAgustusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAgustusItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbAgustus, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbJanuari, cbSeptember, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbAgustusItemStateChanged

    private void cbSeptemberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSeptemberItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbSeptember, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbJanuari, cbOktober, cbNovember, cbDesember);
    }//GEN-LAST:event_cbSeptemberItemStateChanged

    private void cbOktoberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOktoberItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbOktober, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbJanuari, cbNovember, cbDesember);
    }//GEN-LAST:event_cbOktoberItemStateChanged

    private void cbNovemberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNovemberItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbNovember, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbJanuari, cbDesember);
    }//GEN-LAST:event_cbNovemberItemStateChanged

    private void cbDesemberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDesemberItemStateChanged
        classFunction.checkboxOneSelection(cbReportSelect, cbDesember, cbFebruari, cbMaret, cbApril, cbMei, cbJuni, cbJuli, cbAgustus, cbSeptember, cbOktober, cbNovember, cbJanuari);
    }//GEN-LAST:event_cbDesemberItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDataAddNew;
    private javax.swing.JButton btDataDelete;
    private javax.swing.JButton btDataEdit;
    private javax.swing.JButton btDataSave;
    private javax.swing.JButton btGajiAddNew;
    private javax.swing.JButton btGajiDelete;
    private javax.swing.JButton btGajiEdit;
    private javax.swing.JButton btGajiSave;
    private javax.swing.JButton btInputAddNew;
    private javax.swing.JButton btInputDelete;
    private javax.swing.JButton btInputEdit;
    private javax.swing.JButton btInputSave;
    private javax.swing.JButton btReportAddNew;
    private javax.swing.JButton btReportCetak;
    private javax.swing.JCheckBox cbAgustus;
    private javax.swing.JCheckBox cbApril;
    private javax.swing.JComboBox<String> cbDataJabatan;
    private javax.swing.JComboBox<String> cbDataKelamin;
    private javax.swing.JCheckBox cbDesember;
    private javax.swing.JCheckBox cbFebruari;
    private javax.swing.JComboBox<String> cbInputBulan;
    private javax.swing.JComboBox<String> cbInputGajiID;
    private javax.swing.JComboBox<String> cbInputJabatan;
    private javax.swing.JComboBox<String> cbInputTahun;
    private javax.swing.JCheckBox cbJanuari;
    private javax.swing.JCheckBox cbJuli;
    private javax.swing.JCheckBox cbJuni;
    private javax.swing.JCheckBox cbMaret;
    private javax.swing.JCheckBox cbMei;
    private javax.swing.JCheckBox cbNovember;
    private javax.swing.JCheckBox cbOktober;
    private javax.swing.JComboBox<String> cbReportIDKaryawan;
    private javax.swing.JComboBox<String> cbReportSelect;
    private javax.swing.JComboBox<String> cbReportTahun;
    private javax.swing.JCheckBox cbSeptember;
    private org.jdesktop.swingx.JXDatePicker dtDataLahir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDataNewIDPegawai;
    private javax.swing.JLabel lbInputIdPenggajian;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JLabel lbnama;
    private javax.swing.JLabel logo_;
    private javax.swing.JTable tb_gaji;
    private javax.swing.JTable tb_pegawai;
    private javax.swing.JTable tb_penggajian;
    private javax.swing.JTextField txtDataAlamat;
    private javax.swing.JTextField txtDataHP;
    private javax.swing.JTextField txtDataLahir;
    private javax.swing.JTextField txtDataNamaKaryawan;
    private javax.swing.JTextField txtGajiID;
    private javax.swing.JTextField txtGajiJabatan;
    private javax.swing.JTextField txtGajiTotal;
    private javax.swing.JTextField txtInputNama;
    private javax.swing.JTextField txtInputTotal;
    private javax.swing.JTextField txtReportNama;
    // End of variables declaration//GEN-END:variables
}
