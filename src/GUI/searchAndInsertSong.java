/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Artist;
import model.DBManager;
import model.Musicgroup;
import model.Playlist;
import model.Song;

/**
 *
 * @author sotos
 */
public class searchAndInsertSong extends javax.swing.JFrame {
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    private songListsManagementForm slmf;
    private EntityManager em;
    private List<Song> selSongs = new ArrayList();
    private List<Song> refinedSongs = new ArrayList();
    Playlist playlist1;
    Song song;
    DefaultTableModel model;
    int s;
    
    /**
     * Creates new form searchAndInsertSong
     */
    public searchAndInsertSong(songListsManagementForm slmf) {
        em = DBManager.em;
        this.slmf = slmf;
        playlist1 = slmf.playlist1;
        initComponents();
        model = getjTable1Model();
        
        // Γεμίζει τον πίνακα με τα τραγούδια της λίστας
        setJTable(jTable1, songList);
        
        // Γίνεται έλεγχος και κατάλληλη ενεργοποίηση των κουμπιών
        checkControls();
    }

    private void setJTable(javax.swing.JTable jTable, List<Song> obj) {
        Long tmpGroupId;
        Long tmpArtistId;
        String tmpName ="";
                
        for (Song s : obj) {
            if(s.getAlbumId().getMusicgroupList().size() > 0){
                tmpGroupId = s.getAlbumId().getMusicgroupList().get(0).getGroupId();
                TypedQuery<Musicgroup> musicgroupQuery = em.createQuery("SELECT m FROM Musicgroup m WHERE m.groupId = :groupId", Musicgroup.class).setParameter("groupId", tmpGroupId);
                Musicgroup g = musicgroupQuery.getSingleResult();
                tmpName = g.getName();
            }
            else if(s.getAlbumId().getArtistList().size() > 0){
                tmpArtistId = s.getAlbumId().getArtistList().get(0).getArtistId();
                TypedQuery<Artist> artistQuery = em.createQuery("SELECT a FROM Artist a WHERE m.artistId = :artistId", Artist.class).setParameter("artistId", tmpArtistId);
                Artist a = artistQuery.getSingleResult();
                tmpName = (a.getLastname() + " " + a.getFirstname());
            }
            //Τοποθετεί στον πίνακα τις πληροφορίες των τραγουδιών
            model.addRow(new Object[]{s.getTitle(), tmpName, sdf.format(s.getDuration())});
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

        playlist2 = playlist1;
        songQuery = em.createQuery("SELECT s FROM Song s WHERE s NOT IN (SELECT s FROM Song s JOIN s.playlistList playlist WHERE playlist = :pl) ORDER BY s.title").setParameter("pl", playlist2);
        songList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(songQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Αναζήτηση και Εισαγωγή Τραγουδιών");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_32_32.png"))); // NOI18N
        jLabel1.setText("Αναζήτηση και Εισαγωγή Τραγουδιών");

        jButton1.setText("Αναζήτηση");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel2.setText("Διαθέσιμα Τραγούδια");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Τίτλος", "Καλλιτέχνης/Συγκρότημα", "Διάρκεια"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jButton2.setText("Εισαγωγή");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ακύρωση");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Έλεγχος και ενεργοποίηση των κουμπιών
    private void checkControls() {
        s = jTable1.getSelectedRow();
        jButton2.setEnabled(s >= 0);
    }
    
    private void closeMe(boolean exitAndSave) {
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, exitAndSave);
        for (WindowListener l : this.getWindowListeners()) {
            l.windowClosed(we);
        }
        this.setVisible(false);
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        em.getTransaction().rollback();
        em.getTransaction().begin();
        closeMe(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        checkControls();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int[] sr = jTable1.getSelectedRows();
        for (int i : sr) {
            song = songList.get(i);
            if(slmf.songList.contains(song)){
                JOptionPane.showMessageDialog(this, "Το τραγούδι " + song.getTitle() + " υπάρχει ήδη στη λίστα.", "Λάθος στην εισαγωγή", JOptionPane.WARNING_MESSAGE);
            }else{
                selSongs.add(song);
                slmf.songList.add(song);
            }
        }
        slmf.setJTable(jTable1, selSongs);
        closeMe(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Long tmpGroupId;
        Long tmpArtistId;
        String tmpName ="";
        //refinedSongs.clear();
        List<Song> orisongList = new ArrayList();
        for(Song s : songList){
            orisongList.add(s);
        }
        songList.clear();
        
        String searchCriteria = jTextField1.getText().trim();
        System.out.println("Search Criteria = " + searchCriteria);
        
        for(Song s : orisongList){
            if(s.getAlbumId().getMusicgroupList().size() > 0){
                tmpGroupId = s.getAlbumId().getMusicgroupList().get(0).getGroupId();
                TypedQuery<Musicgroup> musicgroupQuery = em.createQuery("SELECT m FROM Musicgroup m WHERE m.groupId = :groupId", Musicgroup.class).setParameter("groupId", tmpGroupId);
                Musicgroup g = musicgroupQuery.getSingleResult();
                if(s.getTitle().contains(searchCriteria) || g.getName().contains(searchCriteria)){
                    //System.out.println("Song Title: " + s.getTitle() + ", of musicgroup: " + g.getName());
                    //refinedSongs.add(s);
                    songList.add(s);
                }
            }
            else if(s.getAlbumId().getArtistList().size() > 0){
                tmpArtistId = s.getAlbumId().getArtistList().get(0).getArtistId();
                TypedQuery<Artist> artistQuery = em.createQuery("SELECT a FROM Artist a WHERE m.artistId = :artistId", Artist.class).setParameter("artistId", tmpArtistId);
                Artist a = artistQuery.getSingleResult();
                if(s.getTitle().contains(searchCriteria) || a.getLastname().contains(searchCriteria) || a.getFirstname().contains(searchCriteria)){
                    //System.out.println("Song Title: " + s.getTitle() + ", of artist: " + a.getLastname() + " " + a.getFirstname());
                    //refinedSongs.add(s);
                    songList.add(s);
                }
            }
        }
        for(Song s : songList){
            System.out.println("Song Title: " + s.getTitle());
        }
        //model.setRowCount(0);
        //setJTable(jTable1, refinedSongs);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); // notifies the JTable that the model has changed
        setJTable(jTable1, songList);
    }//GEN-LAST:event_jButton1ActionPerformed

    public DefaultTableModel getjTable1Model() {
        return (DefaultTableModel)jTable1.getModel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private model.Playlist playlist2;
    private java.util.List<model.Song> songList;
    private javax.persistence.Query songQuery;
    // End of variables declaration//GEN-END:variables
}
