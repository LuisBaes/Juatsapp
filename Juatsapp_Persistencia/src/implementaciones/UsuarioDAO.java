/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import entidades.Usuario;
import singleton.SingletonMongo;
import implementaciones.ConexionBD;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Chat;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public class UsuarioDAO implements IUsuariosDAO{

    private IConexionBD conexion;
    private ConexionBD conexionBD;
    private MongoDatabase bd;
    private IUsuariosDAO ud;
    private MongoCollection mc;
    private SingletonMongo snglMongo;
    
    public UsuarioDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.bd = this.conexion.crearConexion();
    }

    public UsuarioDAO() {
    }
    
    @Override
    public MongoCollection<Usuario> getColeccion() {
//        return this.bd.getCollection("usuarios", Usuario.class);

//       MongoDatabase bd2 = snglMongo.getMongoClient();
       MongoDatabase bd = this.crearConexion();
       MongoCollection<Usuario> coleccion = bd.getCollection("usuarios", Usuario.class);
       return coleccion;
    }    
    
    private static final String HOST = "localhost";
    private static final int PUERTO = 27017;
    private static final String BASE_DATOS = "juatsapp";
    
    public MongoDatabase crearConexion() {
        try{
            //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            
            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);
            
            MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();
            
            MongoClient clienteMongo = MongoClients.create(clientsSettings);
            
            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);
            
            return baseDatos;           
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean agregar(Usuario usuario) {
     MongoCollection<Usuario> coleccion = this.getColeccion();
     coleccion.insertOne(usuario);
     return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
      MongoCollection<Usuario> coleccion = this.getColeccion();
      Document filtroEliminacion =new Document("_id",id);
      coleccion.deleteOne(filtroEliminacion);
      return true;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        MongoCollection<Usuario> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id",usuario.getId());
        
        Document datosActualizados=new Document("$set"
                ,new Document("emailUsuario",usuario.getEmailUsuario())
                        .append("edad", usuario.getEdad())              
                        .append("sexo", usuario.getSexo())                        
                        .append("contrasenia", usuario.getContrasenia()));
        
        coleccion.findOneAndUpdate(filtroActualizacion,datosActualizados);
        return true;
    }

    @Override
    public Usuario buscarPorId(ObjectId id) {
       MongoCollection<Usuario> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id",id);        
        FindIterable<Usuario> usuarios = coleccion.find(filtroBusqueda);
        Usuario usuario = usuarios.first();
        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
       MongoCollection<Usuario> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("emailUsuario",email);        
        FindIterable<Usuario> usuarios = coleccion.find(filtroBusqueda);
        Usuario usuario = usuarios.first();
        return usuario;
    }
    
    @Override
    public Usuario buscarPorEmailyContra(String email,String contra){
        MongoCollection<Usuario> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("emailUsuario",email);
        filtroBusqueda.append("contrasenia", contra);
        FindIterable<Usuario> usuarios = coleccion.find(filtroBusqueda);
        Usuario usuario = usuarios.first();
        return usuario;
    }

    @Override
    public List<Usuario> mostrarTodas() {
      MongoCollection<Usuario> coleccion = this.getColeccion();
      FindIterable<Usuario> usuarios = coleccion.find();
      ArrayList<Usuario> listaUsuarios = new ArrayList(); 
      return usuarios.into(listaUsuarios);
    }

//    @Override
//    public MongoCollection<Usuario> getColeccion() {
//       return this.bd.getCollection("usuarios", Usuario.class);        
////       MongoDatabase bd = this.getDatabase();
////       MongoCollection<Usuario> coleccion = bd.getCollection("usuarios", Usuario.class);
////       return coleccion;
//    }
    
}
