/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.EntityManager;

/**
 *
 * @author theo
 */
public class DBManager {
    public static final EntityManager em = 
            javax.persistence.Persistence.createEntityManagerFactory("RadioStationPU").createEntityManager();
}
