/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.perpustakaan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PaulTitto
 */
public class Peminjaman extends javax.swing.JFrame {

    /**
//     * Creates new form Peminjaman
     */
    public Peminjaman() {
        initComponents();
        LoadData();
        LoadDataBuku();
        LoadDataAnggota();
        LoadDataPeminjaman();
        IDOtomatis();
    }
    
     private void IDOtomatis(){
        try{
            Connection kon=db_koneksi.koneksiDb();
            Statement st=kon.createStatement();
            String sql_id="SELECT * FROM peminjaman order by id_peminjaman desc";
            ResultSet rs=st.executeQuery(sql_id);
            if(rs.next()){
                String id_peminjaman=rs.getString("id_peminjaman").substring(2);
                String AN=""+(Integer.parseInt(id_peminjaman)+1);
                String Nol="";
                switch (AN.length()) {
                    case 1 -> Nol = "0000";
                    case 2 -> Nol = "000";
                    case 3 -> Nol = "00";
                    default -> {
                    }
                }
                ID.setText("PM"+Nol+AN);
                        
            }else{
                ID.setText("PM00001");
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
     
     
     public void LoadDataBuku(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID BUKU"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TableBuku.setModel(data);
        String sql_data = "SELECT id_buku FROM buku";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d[] = {d1};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    private void input_data(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Connection kon=db_koneksi.koneksiDb();
            Statement st= kon.createStatement();            
            String sql = "INSERT INTO peminjaman values('"+ID.getText()
                    +"','"+IDAnggota.getText()
                    +"','"+IDBuku.getText()
                    +"','"+(String) sdf.format(tanggalPeminjaman.getDate())
                    +"','"+(String) sdf.format(tanggalTempo.getDate())
                    +"')";
            
            
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Anggota Berhasil diInput");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     public void LoadDataPeminjaman(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID PEMINJAMAN","ID ANGGOTA","ID BUKU","TANGGAL PEMINJAMAN", "TANGGAL JATUH TEMPO"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TablePeminjaman.setModel(data);
        String sql_data = "SELECT * FROM peminjaman";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d4=rs.getString(4);
                String d5=rs.getString(5);
                String d[] = {d1,d2,d3,d4,d5};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    public void LoadDataAnggota(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID ANGGOTA","NIM", "NAMA"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TableAnggota.setModel(data);
        String sql_data = "SELECT id_anggota, nim,nama FROM anggota";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d[] = {d1,d2,d3};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void LoadData(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID BUKU","JUDUL","PENULIS", "NOMOR INVENTARIS", "STOK"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TableSearch.setModel(data);
        String sql_data = "SELECT * FROM buku";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d4=rs.getString(4);
                String d5=rs.getString(5);
                
                String d[] = {d1,d2,d3,d4,d5};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IDAnggota = new javax.swing.JTextField();
        IDBuku = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        BSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSearch = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAnggota = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableBuku = new javax.swing.JTable();
        tanggalPeminjaman = new com.toedter.calendar.JDateChooser();
        tanggalTempo = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablePeminjaman = new javax.swing.JTable();
        NamaAnggota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Peminjaman");

        jLabel2.setText("Kode Anggota");

        ID.setEditable(false);
        ID.setEnabled(false);

        jLabel3.setText("Kode Buku");

        jLabel4.setText("Tanggal Peminjaman");

        jLabel5.setText("Tanggal Tempo Pengembalian");

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("INPUT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Cari Buku");

        BSearch.setText("SEARCH");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSearchActionPerformed(evt);
            }
        });

        TableSearch.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableSearch);

        TableAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        TableAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAnggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableAnggota);

        jButton3.setText("Kode Anggota or NIM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search Kode Buku");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        TableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        TableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBukuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableBuku);

        tanggalPeminjaman.setDateFormatString("yyyy-MM-dd");

        tanggalTempo.setDateFormatString("yyyy-MM-dd");
        tanggalTempo.setFocusTraversalPolicyProvider(true);

        TablePeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TablePeminjaman);

        jLabel7.setText("Search Nama");

        jLabel8.setText("Search Anggota ID or NIM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(84, 84, 84)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(108, 108, 108)
                                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6))
                                    .addGap(101, 101, 101)
                                    .addComponent(BSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(85, 85, 85))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel1)
                                        .addComponent(NamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IDBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IDAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(271, 271, 271)
                                            .addComponent(tanggalPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(110, 110, 110)
                                            .addComponent(tanggalTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tanggalPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggalTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(64, 64, 64)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(IDBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BSearch))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableSearch.getModel();
        TableRowSorter<DefaultTableModel> obj= new TableRowSorter<>(ob);
        TableSearch.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_BSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableAnggota.getModel();
        TableRowSorter<DefaultTableModel> obj= new TableRowSorter<>(ob);
        TableAnggota.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(IDAnggota.getText()));
        obj.setRowFilter(RowFilter.regexFilter(NamaAnggota.getText()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableBuku.getModel();
        TableRowSorter<DefaultTableModel> obj= new TableRowSorter<>(ob);
        TableBuku.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(IDBuku.getText()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FPerpustakawan().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAnggotaMouseClicked
        // TODO add your handling code here:
         int bar = TableAnggota.getSelectedRow();
        String a = TableAnggota.getValueAt(bar, 0).toString();
        String b = TableAnggota.getValueAt(bar, 2).toString();
        
        
        IDAnggota.setText(a);
        NamaAnggota.setText(b);
    }//GEN-LAST:event_TableAnggotaMouseClicked

    private void TableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBukuMouseClicked
        // TODO add your handling code here:
        int bar = TableBuku.getSelectedRow();
        String a = TableBuku.getValueAt(bar, 0).toString();
        
        
        IDBuku.setText(a);
    }//GEN-LAST:event_TableBukuMouseClicked
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int simpan = JOptionPane.showOptionDialog(this,
                "Apakah Data yang akan di INPUTkan sudah Benar? SIMPAN?",
                "Simpan",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,null,null);
        if(simpan==JOptionPane.YES_OPTION){
            input_data();
            LoadData();
            new Peminjaman().show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSearch;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDAnggota;
    private javax.swing.JTextField IDBuku;
    private javax.swing.JTextField NamaAnggota;
    private javax.swing.JTable TableAnggota;
    private javax.swing.JTable TableBuku;
    private javax.swing.JTable TablePeminjaman;
    private javax.swing.JTable TableSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser tanggalPeminjaman;
    private com.toedter.calendar.JDateChooser tanggalTempo;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
