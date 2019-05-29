package reservas.hotel;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class QuartoResourceAssembler implements ResourceAssembler<Quarto, Resource<Quarto>>{

    @Override
    public Resource<Quarto> toResource(Quarto quarto){
        return new Resource<Quarto>(quarto,linkTo(methodOn(QuartoController.class).one(quarto.getId())).withSelfRel(),
                                           linkTo(methodOn(QuartoController.class).AllQuartos()).withRel("Quartos"));
    }


}
