package ezau.digitalinnovation.everis.proj.ezpersonalapi.controller;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.MessageResponseDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController                         //IndicaControladorAcessadoAtravesDeAPIrest
@RequestMapping("/ApiEz/01/people")     //IndicaLocalDaRequisição(GET)
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){ //RequestBody Indica que virá de uma requisição
        return personService.createPerson(person);
    }

}
