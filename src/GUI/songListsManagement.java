/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.DBManager;
import model.Playlist;
import model.Song;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sotos
 */
public class songListsManagement extends javax.swing.JFrame {
    private EntityManager em;
    private List<Song> selectedPlaylistSongs;
    int s;
    Playlist pl;
    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
    SimpleDateFormat stf = new SimpleDateFormat("mm:ss");
    Boolean newpressed;
    
    /**
     * Creates new form songListsManagement
     */
    public songListsManagement() {
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

        playlistQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT p FROM Playlist p");
        playlistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(playlistQuery.getResultList());
        playlist1 = new model.Playlist();
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooser1.setDialogTitle("");
        jFileChooser1.setFileFilter(new CustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Λίστες Τραγουδιών");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list_32_32.png"))); // NOI18N
        jLabel1.setText("Λίστες Τραγουδιών");

        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, playlistList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Περιγραφή");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creationdate}"));
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

        jButton1.setText("Δημιουργία");
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

        jButton3.setText("Ενημέρωση");
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

        jButton5.setText("Εξαγωγή Λίστας σε XML");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Εισαγωγή Λίστας από αρχείο XML");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
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
        pl = new Playlist();
        pl.setName("");
        pl.setCreationdate(null);
        
        newpressed = true;
        songListsManagementForm slmf = new songListsManagementForm(pl, newpressed);
        
        slmf.setVisible(true);
        JFrame thisframe = this;
        thisframe.setEnabled(false);
        
        slmf.addWindowListener(new WindowListener(){
            
            @Override
            public void windowClosed(WindowEvent arg0) {
                if (MyWindowEvent.isExitAndSave(arg0)){
                    em.persist(pl);
                    playlistList.add(pl);
                    int row = playlistList.size() - 1;
                    jTable1.setRowSelectionInterval(row, row);
                    jTable1.scrollRectToVisible(jTable1.getCellRect(row, 0, true));
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
                else{
                    
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
            
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jFileChooser1.setDialogTitle("Εξαγωγή Λίστας σε XML");
        //jFileChooser1.setSelectedFile(new File("fileToSave"));
        int index = jTable1.getSelectedRow();
        if(index >= 0) {
            playlist1 = playlistList.get(jTable1.convertRowIndexToModel(index));
            jFileChooser1.setSelectedFile(new File(playlist1.getName()));

            selectedPlaylistSongs = playlist1.getSongList();
            if (selectedPlaylistSongs.size() > 0){
                // Επιλογή ονόματος και path για το xml αρχείο με τη βοήθεια ενός JFileChooser
                int returnVal = jFileChooser1.showSaveDialog(this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = new File(jFileChooser1.getSelectedFile() + ".xml");
                    try {
                        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                        Document doc = docBuilder.newDocument();
                        
                        // Προετοιμασία του rootElement του xml αρχείου
                        Element rootElement = doc.createElement("playlist");

                        // Προετοιμασία των attributes της λίστας
                        Attr attrId = doc.createAttribute("listId");
                        attrId.setValue(playlist1.getListId().toString());
                        rootElement.setAttributeNode(attrId);

                        Attr attrName = doc.createAttribute("name");
                        attrName.setValue(playlist1.getName());
                        rootElement.setAttributeNode(attrName);
                        
                        Attr attrDate = doc.createAttribute("creationdate");
                        attrDate.setValue(sdf.format(playlist1.getCreationdate()));
                        rootElement.setAttributeNode(attrDate);
                       
                        doc.appendChild(rootElement);
                        
                        // Προετοιμασία του element για κάθε τραγούδι της λίστας
                        for(Song s : selectedPlaylistSongs){
                            Element song = doc.createElement("song");
                            rootElement.appendChild(song);
                            
                            // Προετοιμασία των elements του κάθε τραγουδιού
                            Element songId = doc.createElement("songId");
                            songId.appendChild(doc.createTextNode(s.getSongId().toString()));
                            song.appendChild(songId);
                            
                            Element songTitle = doc.createElement("title");
                            songTitle.appendChild(doc.createTextNode(s.getTitle()));
                            song.appendChild(songTitle);
                            
                            Element songDuration = doc.createElement("duration");
                            songDuration.appendChild(doc.createTextNode(stf.format(s.getDuration())));
                            song.appendChild(songDuration);
                            
                            Element songTracknr = doc.createElement("tracknr");
                            songTracknr.appendChild(doc.createTextNode(Integer.toString(s.getTracknr())));
                            song.appendChild(songTracknr);
                            
                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                            
                            DOMSource source = new DOMSource(doc);
                            
                            StreamResult result;
                            result = new StreamResult(file);
                            transformer.transform(source, result);
                        }
                    JOptionPane.showMessageDialog(this, "Έγινε εξαγωγή της λίστας σε xml αρχείο με επιτυχία!");
                    }catch(ParserConfigurationException pce){
                        pce.printStackTrace();
                    }catch(TransformerException tfe){
                        tfe.printStackTrace();
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "H επιλεγμένη λίστα δεν έχει τραγούδια.");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Δεν έχει επιλεγεί λίστα τραγουδιών.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Boolean notexists = true;
        jFileChooser1.setDialogTitle("Εισαγωγή Λίστας από XML");
        
        // Επιλογή xml αρχείου με τη βοήθεια ενός JFileChooser
        int returnVal = jFileChooser1.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(file);
                doc.getDocumentElement().normalize();

                Element playlistElement = doc.getDocumentElement();
                
                // Έλεγχος ύπαρξης λίστας με το ίδιο όνομα
                for(Playlist pl : playlistList){
                    if(pl.getName().equals(playlistElement.getAttribute("name"))) notexists = false;
                }
                // Εάν το όνομα δεν υπάρχει
                if(notexists){
                    Playlist playlist = new Playlist();
                    playlist.setName(playlistElement.getAttribute("name"));
                    playlist.setCreationdate(new Date());

                    NodeList nList = doc.getElementsByTagName("song");

                    List<Song> songList = new ArrayList<>();
                    for (int i = 0; i < nList.getLength(); i++){
                        Node nNode = nList.item(i);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            try{
                                int tmpId = Integer.parseInt(eElement.getElementsByTagName("songId").item(0).getTextContent());
                                TypedQuery<Song> songQuery = em.createQuery("SELECT s FROM Song s WHERE s.songId = :songId", Song.class).setParameter("songId", tmpId);
                                Song s = songQuery.getSingleResult();
                                songList.add(s);
                            }catch (NoResultException ex){
                                JOptionPane.showMessageDialog(this, "Το τραγούδι: " + eElement.getElementsByTagName("title").item(0).getTextContent() + "\nδεν είναι διαθέσιμο.", "Λάθος σε τραγούδι", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    // Έλεγχος εάν η λίστα του xml αρχείου έχει έστω και ένα τραγούδι
                    if(!songList.isEmpty()) {
                        playlist.setSongList(songList);

                        em.persist(playlist);
                        em.getTransaction().commit();
                        em.getTransaction().begin();

                        JOptionPane.showMessageDialog(this, "Η εισαγωγή της λίστας έγινε με επιτυχία.", "Επιτυχής εισαγωγή", JOptionPane.WARNING_MESSAGE);
                        java.util.Collection data = playlistQuery.getResultList(); 
                        for (Object entity : data) { 
                            em.refresh(entity); 
                        } 
                        playlistList.clear(); 
                        playlistList.addAll(data);
                    } else {
                        em.getTransaction().rollback();
                        em.getTransaction().begin();
                        JOptionPane.showMessageDialog(this, "Απέτυχε η εισαγωγή της λίστας γιατί δεν έχει τραγούδια.", "Ανεπιτυχής εισαγωγή", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Προσπάθεια εισαγωγής λίστας με όνομα: " + playlistElement.getAttribute("name") + "\nτο οποίο ήδη υπάρχει.", "Ανεπιτυχής εισαγωγή", JOptionPane.WARNING_MESSAGE);
                }
            }catch (ParserConfigurationException | SAXException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Δεν μπορεί να γίνει ανάγνωση του xml αρχείου.", "Ανεπιτυχής εισαγωγή", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        s = jTable1.getSelectedRow();
        pl = playlistList.get(s);
        
        newpressed = false;
        songListsManagementForm slmf = new songListsManagementForm(pl, newpressed);
        
        slmf.setVisible(true);
        JFrame thisframe = this;
        thisframe.setEnabled(false);
        
        slmf.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent arg0) {
                if (MyWindowEvent.isExitAndSave(arg0)) {
                    em.merge(pl);
                    playlistList.set(s, pl);
                    em.getTransaction().commit();
                    em.getTransaction().begin();
                }
                else{
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    java.util.Collection data = playlistQuery.getResultList();
                    for (Object entity : data){
                        em.refresh(entity);
                    }
                    playlistList.clear();
                    playlistList.addAll(data);
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        checkControls();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        s = jTable1.getSelectedRow();
        pl = playlistList.get(s);
        Object[] options = {"Διαγραφή", "Ακύρωση"};
        int n = JOptionPane.showOptionDialog(this, "Θέλετε να διαγράψετε τη λίστα " + pl.getName() + ";",
                "Επιβεβαίωση Διαγραφής",
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        if(n == 0){
            em.remove(pl);
            playlistList.remove(pl);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private model.Playlist playlist1;
    private java.util.List<model.Playlist> playlistList;
    private javax.persistence.Query playlistQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
