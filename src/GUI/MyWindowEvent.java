/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Window;
import java.awt.event.WindowEvent;

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
}
