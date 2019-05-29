package reservas.hotel;

import org.hibernate.ResourceClosedException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HotelController {

        private final HotelRepository hRepository;
        private final HotelResourceAssembler hAssembler;

        HotelController(HotelRepository hRepository, HotelResourceAssembler hAssembler){
            this.hRepository = hRepository;
            this.hAssembler = hAssembler;
        }

        @GetMapping(value = "/hoteis",produces = "application/json; charset=UTF-8")
        public Resources<Resource<Hotel>> AllHoteis(){

            List<Resource<Hotel>> hoteis = hRepository.findAll().stream()
                    .map(hotel -> new Resource<>(hotel,
                            linkTo(methodOn(HotelController.class).one(hotel.getId())).withSelfRel(),
                            linkTo(methodOn(HotelController.class).AllHoteis()).withRel("Hoteis"))).collect(Collectors.toList());

            return new Resources<>(hoteis,linkTo(methodOn(HotelController.class).AllHoteis()).withSelfRel());
        }

        @GetMapping(value = "/hoteis/{id_hotel}",produces = "application/json; charset=UTF-8")
        public Resource<Hotel> one(@PathVariable Long id_hotel){

            Hotel hoteis = hRepository.findById(id_hotel).orElseThrow(()-> new HotelNotFoundException(id_hotel));

            return hAssembler.toResource(hoteis);

        }
}
