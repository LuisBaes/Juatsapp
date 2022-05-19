//package implementaciones;
//
//import interfaces.IConexionBD;
//import interfaces.IUsuariosDAO;
//import interfaces.IChatsDAO;
//
//public class DAOSFactory {
//    private final static IConexionBD conexion = new ConexionBD();
//    
//    public static IUsuariosDAO crearJugadoresDAO(){
//        return new UsuarioDAO(conexion);
//    }
//    
//    public static IChatsDAO crearChatsDAO(){
//        return new ChatDAO(conexion);
//    }
//}
