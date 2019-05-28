package reservas.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface HotelRepository extends JpaRepository<Hotel,Long> {

}