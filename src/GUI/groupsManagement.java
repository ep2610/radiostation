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
import javax.swing.JOptionPane;
import model.DBManager;
import model.Musicgroup;

/**
 *
 * @author sotos
 */
public class groupsManagement extends javax.swing.JFrame {
    private EntityManager em;
    Musicgroup m;
    int s;
    JFrame thisframe;
    Boolean newpressed;
    
    /**
     * Creates new form groupsManagement
     */
    public groupsManagement() {
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

        musicgroupQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT m FROM Musicgroup m ORDER BY m.name");
        musicgroupList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicgroupQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Πίνακας Συγκροτημάτων");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_32_32.png"))); // NOI18N
        jLabel1.setText("Συγκροτήματα");

        jTable1.setFocusable(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicgroupList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Επωνυμία");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${formationdate}"));
        columnBinding.setColumnName("Ημερομηνία δημιουργίας");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Εισαγωγή νέου");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Διαγραφή");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Μεταβολή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        m = new Musicgroup();
        m.setName("");
        m.setFormationdate(null);
        m.setArtistList(null);
        
        newpressed = true;
        groupsManagementForm gmf = new groupsManagementForm(m, newpressed);
        
        gmf.setVisible(true);
        JFrame thisframe = this;
        thisframe.setEnabled(false);
        
        gmf.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent arg0) {
                if (MyWindowEvent.isExitAndSave(arg0)) {
                    em.persist(m);
                    musicgroupList.add(m);
                    int row = musicgroupList.size() - 1;
                    jTable1.setRowSelectionInterval(row, row);
                    jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
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
                thisframe.setEnabled(true);
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
                thisframe.setEnabled(true);
            }
        }
        );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        checkControls();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        s = jTable1.getSelectedRow();
        m = musicgroupList.get(s);
        
        newpressed = false;
        groupsManagementForm gmf = new groupsManagementForm(m, newpressed);
        
        gmf.setVisible(true);
        JFrame thisframe = this;
        thisframe.setEnabled(false);
        
        gmf.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent arg0) {
                if (MyWindowEvent.isExitAndSave(arg0)) {
                    em.merge(m);
                    musicgroupList.set(s, m);
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
                else{
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    java.util.Collection data = musicgroupQuery.getResultList();
                    for (Object entity : data){
                        em.refresh(entity);
                    }
                    musicgroupList.clear();
                    musicgroupList.addAll(data);
                }
                thisframe.setEnabled(true);
                checkControls();
            }

            @Override
            public void windowActivated(WindowEvent arg0) {
                System.out.println("Window Activated");
            }

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.out.println("Window Closing");
                thisframe.setEnabled(true);
            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                System.out.println("Window Deactivated");
                thisframe.setEnabled(true);
            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                System.out.println("Window Deiconified");
            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                System.out.println("Window Iconified");
            }

            @Override
            public void windowOpened(WindowEvent arg0) {
                System.out.println("Window Opened");
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        s = jTable1.getSelectedRow();
        m = musicgroupList.get(s);
        Object[] options = {"Διαγραφή", "Ακύρωση"};
        int n = JOptionPane.showOptionDialog(this, "Θέλετε να διαγράψετε το συγκρότημα " + m.getName() + ";",
                "Επιβεβαίωση Διαγραφής",
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        if(n == 0){
            em.remove(m);
            musicgroupList.remove(m);
            em.getTransaction().commit();
            em.getTransaction().begin();
            checkControls();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<model.Musicgroup> musicgroupList;
    private javax.persistence.Query musicgroupQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
