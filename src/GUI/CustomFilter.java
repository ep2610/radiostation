/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;

/**
 *
 * @author sotos
 */
public class CustomFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with .xml extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".xml");
    }

    @Override
    public String getDescription() {
        // This description will be displayed in the dialog
        return "XML files (*.xml)";
    }
}
