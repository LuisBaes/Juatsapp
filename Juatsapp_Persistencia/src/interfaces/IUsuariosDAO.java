/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public interface IUsuariosDAO {
    boolean agregar(Usuario usuario);
    boolean eliminar(ObjectId id);
    boolean actualizar(Usuario usuario);
    Usuario buscarPorId(ObjectId id);
    Usuario buscarPorEmail(String email);
    public Usuario buscarPorEmailyContra(String email,String contra);
//    List<Chat> mostarPorIntegrantes(String integrante);
    List<Usuario> mostrarTodas();
    MongoCollection getColeccion();
//    MongoDatabase crearConexion();
}
