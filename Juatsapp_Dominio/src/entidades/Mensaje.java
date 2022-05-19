package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public class Mensaje {

    private ObjectId id;
    private String mensaje;
    private Date fechaHora;
    private ObjectId autor;

    public Mensaje(ObjectId id, String mensaje, Date fechaHora, ObjectId autor) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.autor = autor;
    }    

    public Mensaje(ObjectId id) {
        this.id = id;
    } 
    
    public Mensaje(String mensaje, Date fechaHora, ObjectId autor) {
        this.id = new ObjectId();
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.autor = autor;
    }

    public Mensaje() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setAutor(ObjectId autor) {
        this.autor = autor;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public ObjectId getAutor() {
        return autor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensaje other = (Mensaje) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", mensaje=" + mensaje + ", fechaHora=" + fechaHora + ", autor=" + autor + '}';
    }

    
    

}
