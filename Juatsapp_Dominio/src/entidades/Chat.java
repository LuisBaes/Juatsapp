package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public class Chat {

    private ObjectId id;
    private String tituloChat;
    private List<String> integrantes;
    private Date fechaHora;
    private ObjectId autor;
    private List<Mensaje> mensajes;

    public Chat() {
    }

    public Chat(ObjectId id, String tituloChat, Date fechaHora, ObjectId autor) {
        this.id = id;
        this.tituloChat = tituloChat;
        this.fechaHora = fechaHora;
        this.autor = autor;
        mensajes = new ArrayList<Mensaje>();
    }

    public Chat(ObjectId id, String tituloChat, List<String> integrantes, Date fechaHora, ObjectId autor, List<Mensaje> mensajes) {
        this.id = id;
        this.tituloChat = tituloChat;
        this.integrantes = integrantes;
        this.fechaHora = fechaHora;
        this.autor = autor;
        this.mensajes = mensajes;
    }

    public Chat(String tituloChat, List<String> integrantes, Date fechaHora, ObjectId autor, List<Mensaje> mensajes) {
        this.tituloChat = tituloChat;
        this.integrantes = integrantes;
        this.fechaHora = fechaHora;
        this.autor = autor;
        this.mensajes = mensajes;
    }

    public Chat(String tituloChat, Date fechaHora, ObjectId autor) {
        this.tituloChat = tituloChat;
        this.fechaHora = fechaHora;
        this.autor = autor;
        mensajes = new ArrayList<Mensaje>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTituloChat() {
        return tituloChat;
    }

    public void setTituloChat(String tituloChat) {
        this.tituloChat = tituloChat;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ObjectId getAutor() {
        return autor;
    }

    public void setAutor(ObjectId autor) {
        this.autor = autor;
    }

    public List<Mensaje> getMensajes() {
//        if (mensajes.isEmpty()) {
//            return null;
//        } else {
        return mensajes;
//        }

    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }
    
    public void eliminarMensaje(Mensaje mensaje){
        mensajes.remove(mensaje);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Chat other = (Chat) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chat{" + "id=" + id + ", tituloChat=" + tituloChat + ", integrantes=" + integrantes + ", fechaHora=" + fechaHora + ", autor=" + autor + ", mensajes=" + mensajes + '}';
    }

}
