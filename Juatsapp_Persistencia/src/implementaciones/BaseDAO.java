/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Baez
 */
public abstract class BaseDAO<T> {
     private final String SERVIDOR = "localhost";
        private final int PUERTO = 27017;
        
    protected MongoDatabase getDatabase() {
       
        try {
            // CONFIGURACIÓN PARA QUE MONGO HAGA EL MAPEO DE POJOS AUTOMATICAMENTE
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), 
                    pojoCodecRegistry);
            
            // OBJETO QUE EMPAQUETA UNA CADENA DE CONEXION
            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+SERVIDOR+"/"+PUERTO);
            
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry).build();
            
            MongoClient servidor = (MongoClient) MongoClients.create(clientSettings);

            MongoDatabase bd = servidor.getDatabase("juatsapp");
            return bd;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }

    }
    
    

    public abstract void agregar(T entidad);

    public abstract void eliminar(ObjectId id);

    public abstract void actualizar(T entidad);

    public abstract T buscarPorId(ObjectId id);

    public abstract List<T> mostrarTodas();
    
    public abstract MongoCollection getColeccion();
}
