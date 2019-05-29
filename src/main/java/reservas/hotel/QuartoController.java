package reservas.hotel;


import org.hibernate.ResourceClosedException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ResolveResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class QuartoController {

    private QuartoRepository qRepository;
    private QuartoResourceAssembler qAssembler;

    QuartoController(QuartoRepository qRepository, QuartoResourceAssembler qAssembler){
        this.qRepository = qRepository;
        this.qAssembler = qAssembler;
    }

    @GetMapping(value = "/quartos",produces = "application/json; charset=UTF-8")
    public Resources<Resource<Quarto>> AllQuartos(){

        List<Resource<Quarto>> quartos = qRepository.findAll().stream().map(quarto->new Resource<>(quarto,linkTo(methodOn(QuartoController.class).one(quarto.getId())).withSelfRel(),
                linkTo(methodOn(QuartoController.class).AllQuartos()).withRel("Quartos"))).collect(Collectors.toList());

        return new Resources<>(quartos,linkTo(methodOn(QuartoController.class).AllQuartos()).withSelfRel());

    }

    @GetMapping(value = "/quartos/{id_quarto}",produces = "application/json; charset=UTF-8")
    public  Resource<Quarto> one(@PathVariable Long id_quarto){

        Quarto quarto = qRepository.findById(id_quarto).orElseThrow(()->new QuartoNotFoundException(id_quarto));

        return qAssembler.toResource(quarto);
    }
}
