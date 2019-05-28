package reservas.hotel;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class HotelController {


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
    public class CompanhiaController {

        private final HotelRepository hRepository;

        CompanhiaController(HotelRepository hRepository){
            this.hRepository = hRepository;
        }

        @GetMapping(value = "/hoteis",produces = "application/json; charset=UTF-8")
        public Resources<Resource<Hotel>> AllHoteis(){

            List<Resource<Hotel>> hoteis = hRepository.findAll().stream()
                    .map(hotel -> new Resource<>(hotel,
                            linkTo(methodOn(HotelController.class).one(hotel.getId())).withSelfRel(),
                            linkTo(methodOn(HotelController.class).AllHoteis()).withRel("Hoteis"))).collect(Collectors.toList());

            return new Resources<>(hoteis,linkTo(methodOn(CompanhiaController.class).AllHoteis()).withSelfRel());

        }

    }
}
