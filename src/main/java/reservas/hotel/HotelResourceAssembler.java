package reservas.hotel;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class HotelResourceAssembler implements ResourceAssembler<Hotel, Resource<Hotel>>{

    @Override
    public Resource<Hotel> toResource(Hotel hotel){
            return new Resource<>(hotel, linkTo(methodOn(HotelController.class).one(hotel.getId())).withSelfRel(),
                                         linkTo(methodOn(HotelController.class).AllHoteis()).withRel("Hoteis"));

    }

}
