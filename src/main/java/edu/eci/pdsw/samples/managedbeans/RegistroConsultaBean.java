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
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name="ConsultasBean")
@SessionScoped
public class RegistroConsultaBean implements Serializable{
    ServiciosPacientes sp = ServiciosPacientes.getInstance();
    Date fechaNacimiento;
    List<Paciente> pacientes = sp.getPacientes();
    public void setFechaNacimiento(String fecha) {
        String a;
        String b;
        String c;
        String[] x=fecha.split("-");
        a = x[0];b =x[1];c = x[2];
        this.fechaNacimiento = new Date(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c));
    }
    public void registrarPaciente(String id, String tipoId, String nombre, String fecha) throws ExcepcionServiciosPacientes{
        String a;String b;String c;
        String[] x=fecha.split("-");
        a = x[0];b =x[1];c = x[2];
        String fechaReal=a + "-" + b + "-" + c;
        Paciente paciente= new Paciente(Integer.parseInt(id), tipoId, nombre,java.sql.Date.valueOf(fechaReal));
        sp.registrarNuevoPaciente(paciente);
        pacientes=sp.getPacientes();
    }
    public List<Paciente> getPacientes(){
        return pacientes;
    }
   
}
