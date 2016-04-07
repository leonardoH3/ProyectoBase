/*
 * Copyright (C) 2016 hcadavid
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
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientesStub;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author hcadavid
 */
public class PacientesTest {
    
    public PacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    /**
     * Clases de equivalencia:
     * 1-El paciente ya se encuentra registrado
     * 2-El paciente no se encuentra registrado
     */
    
    public void registroPacienteTest(){
        try {
            //Se esta haciendo el test de la clase de equivalencia 1 con stub
            Paciente pac=new Paciente(1, "CC", "Eduardo", new Date(5,5,1995));
            ServiciosPacientes a=ServiciosPacientes.getInstance("stub");
            a.registrarNuevoPaciente(pac);
            a.registrarNuevoPaciente(pac);
            Assert.fail("El paciente no se añadio correcamente");
        } catch (ExcepcionServiciosPacientes ex) {
            Assert.assertEquals("Mal trabajo",ex.getMessage(),"Ya se encuentra registrado el paciente");
            
        }
        }
    @Test
    public void registroPacienteTest1() throws ExcepcionServiciosPacientes{
            //Se esta haciendo el test de la clase de equivalencia 2 con stub
            Paciente pac=new Paciente(1, "CC", "Eduardo", new Date(5,5,1995));
            ServiciosPacientes a=ServiciosPacientes.getInstance("stub");
            a.registrarNuevoPaciente(pac);
            Assert.assertEquals("El paciente no se añadio correcamente","Eduardo",a.consultarPaciente(1, "CC").getNombre());
        }
       
}
