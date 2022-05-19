/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//import interfaces.IConexionBD;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author CAPACITACION
 */
public class SingletonMongo {

    private static MongoClient mClient;
 
    // SingletonMongo for MongoClient
    // Creates a single connection pool internally
    public MongoClient getMongoClient() {
        if (mClient == null) {
            mClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        }
        return mClient;
    }
 
    // Utility method to get database instance
    public MongoDatabase getDB() {
        return getMongoClient().getDatabase("juatsapp");
    }
 
    // Utility method to get user collection
    public MongoCollection<Document> getUserCollection() {
        return getDB().getCollection("usuarios");
    }
    
    public MongoCollection<Document> getChatCollection() {
        return getDB().getCollection("chats");
    }    
 
//    public static void main(String[] args) {
//        SingletonMongo snglMongo = new SingletonMongo();
////        snglMongo.insertUser();
//        snglMongo.queryUsers();
//    }
 
    // Read all documents from user collection
    private void queryUsers() {
        getUserCollection().find().forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                System.out.println(t);
            }
        });
    }
 
    // Insert a document in user collection
//    private void insertUser() {
//        Document document = new Document("nombreUsuario","qpt")
//                            .append("emailUsuario", "testemail@example.com");
//        getUserCollection().insertOne(document);
//    }
}    
    
//    private static final String HOST = "localhost";
//    private static final int PUERTO = 27017;
//    private static final String BASE_DATOS = "juatsapp";    
//    
//    private conexionSingleton(){
//    MongoDatabase crearConexion() {
//        try{
//            //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
//            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//            
//            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
//            
//            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);
//            
//            MongoClientSettings clientsSettings = MongoClientSettings.builder()
//                .applyConnectionString(cadenaConexion)
//                .codecRegistry(codecRegistry)
//                .build();
//            
//            MongoClient clienteMongo = MongoClients.create(clientsSettings);
//            
//            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);
//            
//            return baseDatos;           
//        }catch(Exception ex){
//            System.err.println(ex.getMessage());
//            return null;
//        }
//    }
//    }  
//    private static SingletonMongo singleton;
//    
//    private SingletonMongo(){
//    }
//    
//    public static SingletonMongo getInstance(){
//        if(singleton == null){
//            singleton = new SingletonMongo();
//        }
//        return singleton;
//    }
//    


