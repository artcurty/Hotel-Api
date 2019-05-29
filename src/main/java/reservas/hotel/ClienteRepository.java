package reservas.hotel;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface ClienteRepository extends JpaRepository<Cliente,Long> {

        List<Cliente> findClientesByQuartoId(Long id_quarto);

        Cliente findClienteByIdAndQuartoId(Long id_cliente, Long id_quarto);


}