package reservas.hotel;

public class HotelNotFoundException extends RuntimeException {

    HotelNotFoundException(Long id_hotel){

        super("Não existe hotel com o ID:" + id_hotel);
    }
}
