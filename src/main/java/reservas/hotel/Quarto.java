package reservas.hotel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Quarto {
    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    // ocupado, preço, id, numero de leitos, numero do quarto
}
