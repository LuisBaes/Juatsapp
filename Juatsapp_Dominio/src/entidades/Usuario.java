package entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public class Usuario {
    private ObjectId id;
    private String email;
    private String edad;
    private char sexo;
    private String contrasenia;

    public Usuario() {
    }
    
    public Usuario(ObjectId id, String email, String edad, char sexo, String contrasenia) {
        this.id = id;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
    }

    public Usuario(String email, String edad, char sexo, String contrasenia) {
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.contrasenia = contrasenia;
    }

//    public Usuario() {
//        generosPelicula = new ArrayList();
//        generosMusicales = new ArrayList();;
//    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmailUsuario() {
        return email;
    }

    public void setEmailUsuario(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", edad=" + edad + ", sexo=" + sexo + ", contrasenia=" + contrasenia + '}';
    }

     
    
    
}
