/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javageneric.generic;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kmalif
 */
public class Playlist extends javax.swing.JFrame {
    MusicCollections collections = new MusicCollections();
    
    //lebar tinggi kolom tabel
    private void resizeListener(){
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeColumns();
            }
        
        });
    }
    
    private void resizeColumns(){
    
        float[] columnWidthPercentage = {90.0f, 10.0f};
        int tableWidth = tblPlaylist.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = tblPlaylist.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i]*tableWidth);
            column.setPreferredWidth(pWidth);
            tblPlaylist.setRowHeight(27);
            
        }
    }
    
    private String fileSize(File file){
        DecimalFormat format = new DecimalFormat("#.##");
        long MB = 1024 * 1024;
        long KB = 1024;
        final double length = file.length();
        if (length > MB) {
            return format.format(length/MB)+ "MB";
        }
        if (length > KB) {
            return format.format(length/KB)+ "KB";
        }
        return format.format(length) + "B";
    }
    
    
    private String extensionsOf(File file){
        String fileExtensions = "";
        String fileName = file.getName();
        if(fileName.contains(".") && fileName.lastIndexOf(".")!=0){
            fileExtensions = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        return fileExtensions;
    }
    
    //add semua file mp3
    private void addFiles(File[]files){
        for (File file : files){
            String path = file.getAbsolutePath();
            String fn = file.getName();
            String fileName = fn.substring(0, fn.length()-4);
            String Size = fileSize(file);
            String extension = "";
            int i = path.lastIndexOf('.');
            if(i>0){
                extension = extensionsOf(file);
            }
            Musik m = new Musik(path, fileName, fileName, extension);
            collections.add(m);
        }
    }
    
    
    //read all mp3 file in the folder and sub folder
    public void addFolder(File dir){
        File[] listOfFiles = dir.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String path = listOfFile.getAbsolutePath();
                String fn = listOfFile.getName();
                String fileName = fn.substring(0, fn.length()-4);
                String fileSize = fileSize(listOfFile);
                String extension;int i = path.lastIndexOf('.');
                if (i > 0) {
                    extension = extensionsOf(listOfFile);
                    if ("mp3".equalsIgnoreCase(extension)) {
                        Musik m = new Musik(path, fileName, fileSize, extension);
                        collections.add(m);
                    }
                }else if(listOfFile.isDirectory()){
                    addFolder(listOfFile);
                }
            }
        }
    }
    
    
    

    
    
    
    
    
    public Playlist() {
        initComponents();
        tblPlaylist.setModel(collections);
        resizeColumns();
        resizeListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTombol = new javax.swing.JPopupMenu();
        addFiles = new javax.swing.JMenuItem();
        addFolder = new javax.swing.JMenuItem();
        clearPlaylist = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();
        pnFooter = new javax.swing.JPanel();
        btnPlaylist = new javax.swing.JButton();

        addFiles.setText("jMenuItem1");
        addFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilesActionPerformed(evt);
            }
        });
        popupTombol.add(addFiles);

        addFolder.setText("jMenuItem1");
        addFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderActionPerformed(evt);
            }
        });
        popupTombol.add(addFolder);

        clearPlaylist.setText("jMenuItem2");
        clearPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPlaylistActionPerformed(evt);
            }
        });
        popupTombol.add(clearPlaylist);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPlaylist.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlaylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlaylist);

        btnPlaylist.setText("Playlist");
        btnPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnPlaylist)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnPlaylist)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addComponent(pnFooter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaylistActionPerformed
        popupTombol.show(btnPlaylist, btnPlaylist.getWidth(), btnPlaylist.getHeight()/2);
    }//GEN-LAST:event_btnPlaylistActionPerformed

        //event menu Addfiles
    private void addFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilesActionPerformed
       JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle("Add Files");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("MP3 FIle(*.mp3)", "mp3"));
        fc.setApproveButtonText("Add Files");
        int show = fc.showOpenDialog(this);
        if (show == JFileChooser.APPROVE_OPTION) {
            File[]  files = fc.getSelectedFiles();
            addFiles(files);
          
        }
    }//GEN-LAST:event_addFilesActionPerformed
        //menu add Folder action
    private void addFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Add Folder");
        fc.setApproveButtonText("Add Folder");
        int show = fc.showOpenDialog(this);
        if (show == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            addFolder(file);
            
        }
    }//GEN-LAST:event_addFolderActionPerformed

    private void clearPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPlaylistActionPerformed
        collections.clear();
    }//GEN-LAST:event_clearPlaylistActionPerformed

    private void tblPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlaylistMouseClicked
        int i = tblPlaylist.getSelectedRow();
        if (evt.getClickCount() ==2 && i != -1) {
            Musik m = collections.get(i);
            JOptionPane.showMessageDialog(this,
                    "<html>"
                    + "<head>"
                    + "<style>"
                    + "table {border-collapse: collapse; border: 1px solid blue;}"
                    + "tr{border-bottom: 1pt solid black;}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h3>Detail Musik</h3>"
                    + "<table>"
                    + "<tr><td>Lokasi</td><td>:</td><td>"+m.getPath()+ "</td></tr>"
                    + "<tr><td>Nama</td><td>:</td><td>"+m.getFileName()+ "</td></tr>"
                    + "<tr><td>Ukuran</td><td>:</td><td>"+m.getFileSize()+ "</td></tr>"
                    + "<tr><td>Ekstensi</td><td>:</td><td>"+m.getExtensions()+ "</td></tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>"
                    );
            
        }
    }//GEN-LAST:event_tblPlaylistMouseClicked

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Playlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addFiles;
    private javax.swing.JMenuItem addFolder;
    private javax.swing.JButton btnPlaylist;
    private javax.swing.JMenuItem clearPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPopupMenu popupTombol;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
