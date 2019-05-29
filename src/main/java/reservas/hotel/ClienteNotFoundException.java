package reservas.hotel;

public class ClienteNotFoundException extends RuntimeException{

    ClienteNotFoundException(Long id_cliente){

        super("Não existe Cliente com esse ID:" + id_cliente);
    }
}
