package reservas.hotel;

public class QuartoNotFoundException extends RuntimeException {

    QuartoNotFoundException(Long id_quarto){

        super("Não existe quarto com esse ID" + id_quarto);
    }
}
