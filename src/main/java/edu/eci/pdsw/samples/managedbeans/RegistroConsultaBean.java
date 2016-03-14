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

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    ArrayList<Paciente> pacientes = sp.getPacientes();
    String id;
    String idType;
    String nombre;
    String fecha;
    Date fechaNacimiento;
    String consultasId;
    String consultasFecha;
    String resumen;

    public Paciente getPa() {
        return pa;
    }

    public void setPa(Paciente pa) {
        this.pa = pa;
    }
    Paciente pa;
    
    public String getConsultasId() {
        return consultasId;
    }

    public void setConsultasId(String consultasId) {
        this.consultasId = consultasId;
    }

    public String getConsultasFecha() {
        return consultasFecha;
    }

    public void setConsultasFecha(String consultasFecha) {
        this.consultasFecha = consultasFecha;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        String a;String b;String c;
        String[] x=fecha.split("-");
        a = x[0];b =x[1];c = x[2];
        String fechaReal=a + "-" + b + "-" + c;
        Paciente paciente= new Paciente(Integer.parseInt(id), idType, nombre,java.sql.Date.valueOf(fechaReal));
        sp.registrarNuevoPaciente(paciente);
        pacientes=sp.getPacientes();
    }
    public ArrayList<Paciente> getPacientes(){
        return pacientes;
    }
    public void registrarConsulta() throws ParseException, ExcepcionServiciosPacientes{
        Consulta c= new Consulta();
        c.setId(Integer.parseInt(consultasId));
        c.setResumen(resumen);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.util.Date date = sdf.parse(consultasFecha);      
        java.sql.Date sqlDate = new Date(date.getTime());
        c.setFechayHora(sqlDate);
        sp.agregarConsultaAPaciente(pa.getId(), pa.getTipo_id(), c);
    }
   public Set<Consulta> getConsultas(){
       return pa.getConsultas();
   }
}
