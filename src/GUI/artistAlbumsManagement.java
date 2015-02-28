/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author sotos
 */
public class artistAlbumsManagement extends javax.swing.JFrame {
    private static EntityManager em;    
    private List<Album> albumList1 = new ArrayList<>();  //καλάθι
    private DefaultTableModel model;
    SimpleDateFormat sdf= new SimpleDateFormat("EEE, MMM  dd,  yyyy");  //ορίζω το format της ημερομηνίας

    /**
     * Creates new form artistAlbumsManagement
     */
    public artistAlbumsManagement() {
        try {
            em = DBManager.em;
        } catch (Exception e) {
          System.out.println("ERROR:¨"+e.getMessage());
        }
        initComponents();
        setalbumlist();
        setJTable(jTable1, albumList1);
        // Αλλαγή του τρόπου που κλέινει το παράθυρο με το x
        super.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            new mainGUI().setVisible(true);
        }
        });
    }

    // Δημιουργία της λίστας των album
    private void setalbumlist(){
        try {            
            this.albumList1.clear();
                TypedQuery<Album> albumsQuery = em.createQuery("SELECT a FROM Album a", Album.class);
                    for (Album a:albumsQuery.getResultList()){
                        if (a.getArtistList().size()>0) { // εάν το album είναι τραγουδιστή
                        this.albumList1.add(a); // προσθέτει το album στη λίστα
                    }
                }                    
        } catch (Exception e) { // Σε περίπτωση αποτυχίας τυπώνει σφάλμα
            System.out.println("ERROR:¨1"+e.getMessage());
        }           
    }
    
    // Μέθοδος πρόσθεσης κατάλληλα διαμορφωμένων γραμμών στον πίνακα
    private void setJTable(javax.swing.JTable jTable, List<Album> obj) {
        //Μεταβλητές
        Long tmpArtistId;
        String tmpArtistName;
        
        model = (DefaultTableModel) jTable.getModel(); //Χαρακτηριστικά του πίνακα της φόρμας
                
        for (Album a : obj) {
            tmpArtistId = a.getArtistList().get(0).getArtistId();
            TypedQuery<Artist> artistQuery = em.createQuery("SELECT a FROM Artist a WHERE a.artistId = :artistId", Artist.class).setParameter("artistId", tmpArtistId);
            Artist t = artistQuery.getSingleResult();
            tmpArtistName = t.getLastname() + " " + t.getFirstname();

            //Τοποθετεί στον πίνακα τις πληροφορίες των album
            model.addRow(new Object[]{a.getTitle(),a.getType(),a.getMusicproductioncompanycompanyId().getName(),a.getDisknumber(), tmpArtistName, sdf.format(a.getReleasedate())});//εδώ απλά εφαρμόζω την μέθοδο format του SimpleDateFormat που δημιούργησα στην αρχή.
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Πίνακας Άλμπουμ Καλλιτεχνών");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vinyl_32_32.png"))); // NOI18N
        jLabel1.setText("Άλμπουμ Καλλιτεχνών");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Τίτλος", "Τύπος άλμπουμ", "Εταιρεία παραγωγής", "Αριθμός άλμπουμ", "Καλλιτέχνης", "Ημερομηνία κυκλοφορίας"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jButton1.setText("Εισαγωγή νέου");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Διαγραφή");

        jButton3.setText("Ενημέρωση");

        jButton4.setText("Έξοδος");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new mainGUI().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        artistAlbumsManagementForm aamf = new artistAlbumsManagementForm();
        aamf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
