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
import edu.eci.pdsw.samples.services.ServiciosPacientesStub;
import java.sql.Date;
import java.util.Set;
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
    
    - Que el idPaciente y tipoId sean pertenecientes algun paciente existente.
    - Que el idPaciente y tipoId no pertenezcan a algun paciente existente.
    - Que el idPaciente y tipoId no concuerden con el mismo paciente.
    
    */
    public void registroPacienteTest(){
        
        
    }
    
    public void registroConsultas() throws ExcepcionServiciosPacientes{
        /*
        se implemento el test de la clase de equivalencia de la 1
        */

       Paciente pacient = new Paciente(1,"cc","Carlos",new Date(8,8,1994));
       Consulta  consult = new Consulta(new Date (8,8,2012),"Paciente...");
       ServiciosPacientesStub consul = new ServiciosPacientesStub();
       consul.registrarNuevoPaciente(pacient);
       consul.agregarConsultaAPaciente(1, "cc", consult);
       Assert.assertEquals("El paciente si existe","Paciente...",consul.consultarPaciente(1, "cc").getConsultas().contains(consult));    
    }
    
    public void registroConsultas1() throws ExcepcionServiciosPacientes{
        /*
        se implemento el test de la clase de equivalencia de la 2
        */

       Paciente pacient = new Paciente(2,"TI","Andres",new Date(10,10,2012));
       Consulta  consult = new Consulta(new Date (10,10,12),"Paciente Andres");
       ServiciosPacientesStub consul = new ServiciosPacientesStub();
       consul.agregarConsultaAPaciente(2, "TL", consult);
       Assert.assertEquals("El paciente no se encuentra  o no existe","Paciente Andres",consul.consultarPaciente(2, "TI").getConsultas().contains(consult));    
    }
    
    public void registroConsultas2() throws ExcepcionServiciosPacientes{
        /*
        se implemento el test de la clase de equivalencia de la 3
        */

       Paciente pacient = new Paciente(2,"CC","Andres",new Date(10,10,2012));
       Consulta  consult = new Consulta(new Date (10,10,12),"Paciente Andres");
       ServiciosPacientesStub consul = new ServiciosPacientesStub();
       consul.agregarConsultaAPaciente(2, "TL", consult);
       Assert.assertEquals("El IdPaciente y el tipoId no concuerda con el paciente","Paciente Andres",consul.consultarPaciente(2, "TI").getConsultas().contains(consult));
    
    }
}
