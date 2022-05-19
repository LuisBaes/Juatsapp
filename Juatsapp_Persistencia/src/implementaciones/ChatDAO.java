/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import entidades.Mensaje;
import singleton.SingletonMongo;
import interfaces.IChatsDAO;
import entidades.Chat;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
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
public class ChatDAO implements IChatsDAO {

    private IConexionBD conexion;
    private MongoDatabase bd;
    private SingletonMongo snglMongo;
    
    public ChatDAO(IConexionBD conexion){
        this.conexion = conexion;
        this.bd = this.conexion.crearConexion();        
    }
    public ChatDAO() {
    }
    
    @Override
    public MongoCollection<Chat> getColeccion() {
//        return this.bd.getCollection("usuarios", Usuario.class);
//       snglMongo.getMongoClient();
//       snglMongo.get;
//       MongoCollection<Chat> coleccionChats = snglMongo.getChatCollection();
       MongoDatabase bd = this.crearConexion();
       MongoCollection<Chat> coleccion = bd.getCollection("chats", Chat.class);
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
    public boolean agregar(Chat chat) {
        MongoCollection<Chat> coleccion = this.getColeccion();
        coleccion.insertOne(chat);
        return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
        MongoCollection<Chat> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
        return true;
    }

    @Override
    public boolean actualizar(Chat entidad) {
        MongoCollection<Chat> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id", entidad.getId());

        Document datosActualizados = new Document("$set",
                new Document("autor", entidad.getAutor())
                        .append("fechaHora", entidad.getFechaHora())
                        .append("tituloChat", entidad.getTituloChat())
                        .append("integrantes", entidad.getIntegrantes())
                        .append("mensajes", entidad.getMensajes()));
        coleccion.findOneAndUpdate(filtroActualizacion, datosActualizados);
        return true;
    }

    @Override
    public Chat buscarPorId(ObjectId id) {
        MongoCollection<Chat> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Chat> chats = coleccion.find(filtroBusqueda);
        Chat chat = chats.first();
        return chat;
    }

    @Override
    public List<Chat> mostrarPorIntegrantes(String integrante) {

        MongoCollection<Chat> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("integrantes", integrante);

        FindIterable<Chat> chats = coleccion.find(filtroBusqueda);
        for (Chat chat : chats) {
            System.out.println(chat.getAutor());
        }
        ArrayList<Chat> listaChats = new ArrayList();
        return chats.into(listaChats);
    }

    @Override
    public List<Chat> mostrarTodas() {
        MongoCollection<Chat> coleccion = this.getColeccion();
        FindIterable<Chat> chats = coleccion.find();
        
        ArrayList<Chat> listaChats = new ArrayList();
        return chats.into(listaChats);
    }

//    @Override
//    public MongoCollection getColeccion() {
//        return this.baseDatos.getCollection("chats", Chat.class);        
////        MongoDatabase bd = this.getDatabase();
////        MongoCollection<Chat> coleccion = bd.getCollection("chats", Chat.class);
////        return coleccion;
//    }

}
