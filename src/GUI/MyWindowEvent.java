/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author sotos
 */
public class MyWindowEvent extends WindowEvent{
    public boolean exitAndSave;
    
    public MyWindowEvent(Window source, int id, boolean exitAndSave) {
        super(source, id);
        this.exitAndSave = exitAndSave;
    }
    
    public static boolean isExitAndSave(WindowEvent arg0) {          
        if (arg0 instanceof MyWindowEvent) {
            return ((MyWindowEvent) arg0).exitAndSave;
        } else {
            return false;
        }
    }
}
