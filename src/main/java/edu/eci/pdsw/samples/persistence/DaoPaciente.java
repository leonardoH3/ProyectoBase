/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Paciente;
import java.util.ArrayList;

/**
 *
 * @author 2107262
 */
public interface DaoPaciente {
    public Paciente load(int id, String tipoid) throws PersistenceException;
    
    public void save(Paciente p) throws PersistenceException;
    
    public void update(Paciente p) throws PersistenceException;
    
    public ArrayList<Paciente> PacientesTotal() throws PersistenceException;
}
