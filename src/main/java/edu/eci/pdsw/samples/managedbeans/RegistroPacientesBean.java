/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.io.Serializable;
import java.sql.Date;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author 2107262
 */
@ManagedBean
@SessionScoped
public class RegistroPacientesBean implements Serializable {

    ServiciosPacientes sp = ServiciosPacientes.getInstance();
    Paciente paciente = null;
    int id;
    String tipoId;
    String nombre;
    Date fechaNacimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fecha) {
        String a;
        String b;
        String c;
        String[] x=fecha.split("-");
        a = x[0];b =x[1];c = x[2];
        this.fechaNacimiento = new Date(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c));
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        paciente= new Paciente(id, tipoId, nombre, fechaNacimiento);
        sp.registrarNuevoPaciente(paciente);
    }

}
