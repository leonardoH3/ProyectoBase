/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

// load cargar 

package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Consulta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientesStub;
import java.sql.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
/**
 *
 * @author hcadavid
 */
public class ConsultasTest {
    
    public ConsultasTest() {
        
        
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    /*
    CLASES DE EQUIVALENCIA
    
    - Se le añade una consulta a un paciente ya existente.
    - Se añade una consulta a un paciente no existente.

    
    */
    public void registroPacienteTest(){
        
        
    }
    @Test
    public void registroConsultas(){
        try {
            /*
            se implemento el test de la clase de equivalencia de la 1 con stub
            */
            
            Paciente pacient = new Paciente(1,"cc","Carlos",new Date(8,8,1994));
            Consulta  consult = new Consulta(new Date (8,8,2012),"Paciente...");
            ServiciosPacientes consul=ServiciosPacientes.getInstance("stub");
            consul.registrarNuevoPaciente(pacient);
            consul.agregarConsultaAPaciente(1, "cc", consult);   
            Assert.assertEquals("No añadio correctamente la consulta","Paciente...",consul.consultarPaciente(1, "cc").getConsultas().iterator().next().getResumen());
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(ConsultasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void registroConsultas1() throws ExcepcionServiciosPacientes{
       try {
            /*
            se implemento el test de la clase de equivalencia de la 2 con stub
            */
            
            Paciente pacient = new Paciente(2,"CC","Andres",new Date(10,10,2012));
            Consulta  consult = new Consulta(new Date (10,10,12),"Paciente Andres");
            ServiciosPacientes consul=ServiciosPacientes.getInstance("stub");
            consul.agregarConsultaAPaciente(2, "TL", consult);
            Assert.fail("No deberia poder agregarse esa consulta");
        } catch (ExcepcionServiciosPacientes ex) {
            Assert.assertEquals("Incorrecto",ex.getMessage(),"Paciente " + 2 + " no esta registrado");
        }  
    }
}
