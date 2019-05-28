package reservas.hotel;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface ClienteRepository extends JpaRepository<Cliente,Long> {

}