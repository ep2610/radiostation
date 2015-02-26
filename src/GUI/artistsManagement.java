/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import model.Artist;
import model.DBManager;

/**
 *
 * @author sotos
 */
public class artistsManagement extends javax.swing.JFrame {
    private EntityManager em;
    Artist a;
    int s;
    
    /**
     * Creates new form artistsManagement
     */
    public artistsManagement() {
        em = DBManager.em;
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        
        initComponents();
        checkControls();
        // Αλλαγή του τρόπου που κλέινει το παράθυρο με το x
        super.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            new mainGUI().setVisible(true);
        }
        });
    }
    
    // Ενεργοποιεί κατάλληλα τα κουμπιά διαγραφής και επεξεργασίας
    private void checkControls() {
        s = jTable1.getSelectedRow();
        jButton2.setEnabled(s >= 0);
        jButton3.setEnabled(s >= 0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        artistQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT a FROM Artist a");
        artistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(artistQuery.getResultList());
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Αρχείο Καλλιτεχνών");
        setResizable(false);

        jButton1.setText("Εισαγωγή νέου");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Διαγραφή");

        jButton3.setText("Μεταβολή");

        jButton4.setText("Έξοδος");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/artist_32_32.png"))); // NOI18N
        jLabel1.setText("Καλλιτέχνες");

        jTable1.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, artistList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Επώνυμο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${artisticname}"));
        columnBinding.setColumnName("Καλλιτεχνικό όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sex}"));
        columnBinding.setColumnName("Φύλο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthday}"));
        columnBinding.setColumnName("Ημερομηνία γέννησης");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthplace}"));
        columnBinding.setColumnName("Birthplace");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${musicgenregenreId.name}"));
        columnBinding.setColumnName("Είδος μουσικής");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new mainGUI().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a = new Artist();
        //a.setArtistId(new Long(artistList.size()+1));
        a.setLastname("Last");
        a.setFirstname("First");
        a.setArtisticname("");
        a.setSex("");
        a.setBirthday(null);
        a.setBirthplace("");
        a.setMusicgenregenreId(null);

        artistsManagementForm amf = new artistsManagementForm(a);
        
        amf.setVisible(true);
        //artistsManagement thisframe = this;
        JFrame thisframe = this;
        thisframe.setEnabled(false);
        
        amf.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent arg0) {
                if (((MyWindowEvent) arg0).exitAndSave) {                     
                    //System.out.println("a.Firstname: "+a.getFirstname());
                    //em.persist(a);
                    //artistList.add(a);
                    //int row = artistList.size() - 1;
                    //jTable1.setRowSelectionInterval(row, row);
                    //jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));
                    
                }
                else {
                    em.getTransaction().rollback();
                    em.getTransaction().begin();                  
                }
                java.util.Collection data = artistQuery.getResultList();
                for (Object entity : data) {
                    em.refresh(entity);
                }
                artistList.clear();
                artistList.addAll(data);
                
                thisframe.setEnabled(true);
                checkControls();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window Closing");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Window Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window Deiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window Deactivated");
            }
        }
        );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        checkControls();
        if (jButton3.isEnabled() && (evt.getClickCount() > 1)) {
            //jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<model.Artist> artistList;
    private javax.persistence.Query artistQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
