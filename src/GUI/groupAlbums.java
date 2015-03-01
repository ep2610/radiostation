/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Artist;
import model.DBManager;
import model.Musicgroup;

/**
 *
 * @author Elias
 */
public class groupAlbums extends javax.swing.JFrame {
    //private EntityManager em;
    //Musicgroup a;
    //int s;
    //JFrame thisframe;

    /**
     * Creates new form groupAlbums
     */
    public groupAlbums() {
        initComponents();
    
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

        RadioStationPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("RadioStationPU").createEntityManager();
        musicgroupQuery = java.beans.Beans.isDesignTime() ? null : RadioStationPUEntityManager.createQuery("SELECT m FROM Musicgroup m");
        musicgroupList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : musicgroupQuery.getResultList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textField = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Επιλογή");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setText("Ακύρωση");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_32_32.png"))); // NOI18N
        jLabel1.setText("Συγκροτήματα");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicgroupList, textField);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(textField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(23, 23, 23))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void closeMe(boolean exitAndSave) {
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, exitAndSave);
        for (WindowListener l : this.getWindowListeners()) {
            l.windowClosed(we);
        }
        this.setVisible(false);
    }
    
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeMe(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
           /* Get text from TextField */
        int row = textField.getSelectedRow();
        String gNam = (textField.getModel().getValueAt(row, 0).toString());
        String setNewMessage = "";
        boolean isFrameOpen = false;
        

        if (gNam != null && gNam.length() > 0) {
           
            // Get list of opened JFrames 
            
            for (Frame frame : Frame.getFrames()) {
                /* Match title of JFrame */
                if (frame.getTitle().equals("Φόρμα Διαχείρισης 'Αλμπουμ Συγκροτήματος")) {
                    /* Cast to ChildJFrame */
                    groupAlbumsManagementForm childJFrame = (groupAlbumsManagementForm) frame;
                    childJFrame.setEnabled(true);
                   
                    setNewMessage = gNam;
                    /* Set value of TextArea */
                    childJFrame.getgrName().setText(setNewMessage);
                    isFrameOpen = true;
            }
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager RadioStationPUEntityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.util.List<model.Musicgroup> musicgroupList;
    private javax.persistence.Query musicgroupQuery;
    private javax.swing.JTable textField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
