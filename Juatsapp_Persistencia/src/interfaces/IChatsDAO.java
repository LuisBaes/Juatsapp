package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Chat;
import java.util.List;
import org.bson.types.ObjectId;

public interface IChatsDAO {
    boolean agregar(Chat chat);
    boolean eliminar(ObjectId id);
    boolean actualizar(Chat entidad);
    Chat buscarPorId(ObjectId id);
    List<Chat> mostrarPorIntegrantes(String integrante);
    List<Chat> mostrarTodas();
    MongoCollection getColeccion();
//    List<Chat> consultarTodos();
//    Chat consultar(ObjectId idChat);
}
