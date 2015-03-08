/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.glass.events.KeyEvent;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Album;
import model.Artist;
import model.DBManager;
import model.Musicgroup;
import model.Song;
/**
 *
 * @author sotos
 */
public class groupAlbumsManagementForm extends javax.swing.JFrame {
JTable table;
private EntityManager em;
SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
Album a;
List<Song> songList;
List<Musicgroup> musicgroupList;
DefaultTableModel model;
int s;
Boolean newpressed;
Calendar c = Calendar.getInstance();
int x = 0;


    public groupAlbumsManagementForm(Album al, Boolean newspressed) {
        //System.out.println("Point1");
        em = DBManager.em;
        a = al;
        this.newpressed = newpressed;
        initComponents();
        songList = slist1;
        model = getjTable1Model();
        
        setJTable(jTable1, slist1);
        
        // Γεμίζει ανάλογα τα πεδία στο GUI
        if (!(a.getTitle().isEmpty())) {
            jTextField1.setText(a.getTitle());
            jComboBox1.setSelectedItem(a.getType());
            jComboBox3.setSelectedItem(a.getMusicproductioncompanycompanyId());
            jTextField3.setText(a.getDisknumber().toString());
            jComboBox2.setSelectedItem(a.getMusicgroupList());
            jDateChooser1.setDate(a.getReleasedate());
        }
        
    checkControls();
    }
    public void setJTable(javax.swing.JTable jTable, List<Song> obj) {
       //Long tmpGroupId;
        //Long tmpArtistId;
        //String tmpName ="";
        
                
        for (Song so : obj) {
            model.addRow(new Object[]{so.getTitle(), sdf.format(so.getDuration()),so.getTracknr()});
            
        System.out.println(so.getTitle());
            //if(s.getAlbumId().getMusicgroupList().size() > 0){
              //  tmpGroupId = s.getAlbumId().getMusicgroupList().get(0).getGroupId();
                //TypedQuery<Musicgroup> musicgroupQuery = em.createQuery("SELECT m FROM Musicgroup m WHERE m.groupId = :groupId", Musicgroup.class).setParameter("groupId", tmpGroupId);
                //Musicgroup g = musicgroupQuery.getSingleResult();
                //tmpName = g.getName();
           //}
            
            //Τοποθετεί στον πίνακα τις πληροφορίες των τραγουδιών
            
       
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        album1 = a;
        musicProdCompRenderer1 = new GUI.musicProdCompRenderer();
        query2 = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT mp FROM Musicproductioncompany mp");
        list2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query2.getResultList();
        musicGroupRenderer1 = new GUI.musicGroupRenderer();
        query1 = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT m FROM Musicgroup m");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query1.getResultList();
        song1 = new model.Song();
        query3 = em.createQuery("SELECT s FROM Song s JOIN s.albumId albumsongs WHERE albumsongs = :al").setParameter("al", a);
        slist1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query3.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();

        musicProdCompRenderer1.setText("musicProdCompRenderer1");

        musicGroupRenderer1.setText("musicGroupRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Φόρμα Διαχείρισης 'Αλμπουμ Συγκροτήματος");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vinyl_group_18_18.png"))); // NOI18N
        jLabel1.setText("Διαχείριση 'Αλμπουμ Συγκροτήματος");

        jLabel2.setText("Τίτλος");

        jLabel3.setText("Τύπος Άλμπουμ");

        jLabel4.setText("Αριθμός άλμπουμ");

        jLabel5.setText("Εταιρεία παραγωγής");

        jLabel6.setText("Σγκρότημα");

        jLabel7.setText("Ημερομηνία κυκλοφορίας");

        jLabel8.setText("Λίστα τραγουδιών:");

        jTextField1.setToolTipText("Εισάγετε τον Τίτλο του Άλμπουμ");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album1, org.jdesktop.beansbinding.ELProperty.create("${title}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.setToolTipText("Εισάγετε τον Αριθμό του Άλμπουμ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album1, org.jdesktop.beansbinding.ELProperty.create("${disknumber}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setCellSelectionEnabled(true);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(101);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);

        jButton1.setText("Εισαγωγή");
        jButton1.setToolTipText("Πατήστε για Εισαγωγή Τραγουδιού");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Διαγραφή");
        jButton2.setToolTipText("Πατήστε για Διαγραφή του Επιλεγμένου Τραγουδιού");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jButton3.setText("Ακύρωση");
        jButton3.setToolTipText("Ακύρωση και Επιστροφή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setToolTipText("Αποθήκευση Άλμπουμ");
        jButton4.setLabel("Αποθήκευση");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jDateChooser1.setToolTipText("Επιλέξτε Ημερομηνία Κυκλοφορίας");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album1, org.jdesktop.beansbinding.ELProperty.create("${releasedate}"), jDateChooser1, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sc", "ep", "lp" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setToolTipText("Επιλέξτε τον Τύπο Άλμπουμ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album1, org.jdesktop.beansbinding.ELProperty.create("${type}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox2.setToolTipText("Επιλέξτε το Συγκρότημα");
        jComboBox2.setRenderer(musicGroupRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list1, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setToolTipText("Επιλέξτε την Εταιρεία Παραγωγής");
        jComboBox3.setRenderer(musicProdCompRenderer1);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list2, jComboBox3);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, album1, org.jdesktop.beansbinding.ELProperty.create("${musicproductioncompanycompanyId}"), jComboBox3, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(165, 165, 165)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox2, jComboBox3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jComboBox2, jComboBox3});

        jComboBox3.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void checkControls() {
        s = jTable1.getSelectedRow();
        jButton2.setEnabled(s >= 0);
    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        model.addRow(new java.util.Vector<String>(java.util.Arrays.asList(new String[]{"","",""})));
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int index = jTable1.getSelectedRow();
        if(index >= 0){
            model.removeRow(index);   
        }else {
            JOptionPane.showMessageDialog(this, "επιλέξτε την εγγραφή του πίνακα που επιθυμείτε να διαγράψετε.");
        }
    checkControls();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Musicgroup mg = new Musicgroup();
        List <Musicgroup> listM = new ArrayList();
        listM.add((Musicgroup)jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        Song so = new Song();
        List<Song> listS = new ArrayList();
        album1.setSongList(listS);
        album1.setMusicgroupList(listM);
        //mg = ((Musicgroup)jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
        //System.out.println(mg.getName());
        
       
        //em.getTransaction().rollback();
        //em.getTransaction().begin();
        closeMe(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       checkControls();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char c=evt.getKeyChar();
        if(!((Character.isDigit(c)) || (c == KeyEvent.VK_BACKSPACE) || (c == KeyEvent.VK_DELETE))){
         getToolkit().beep();
         evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    private void closeMe(boolean exitAndSave) {
        MyWindowEvent we = new MyWindowEvent(this, WindowEvent.WINDOW_CLOSED, exitAndSave);
        for (WindowListener l : this.getWindowListeners()) {
            l.windowClosed(we);
        }
        this.setVisible(false);
    }
    
    public DefaultTableModel getjTable1Model() {
        return (DefaultTableModel)jTable1.getModel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private model.Album album1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private java.util.List<Musicgroup> list1;
    private java.util.List list2;
    private GUI.musicGroupRenderer musicGroupRenderer1;
    private GUI.musicProdCompRenderer musicProdCompRenderer1;
    private javax.persistence.Query query1;
    private javax.persistence.Query query2;
    private javax.persistence.Query query3;
    private java.util.List<Song> slist1;
    private model.Song song1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}