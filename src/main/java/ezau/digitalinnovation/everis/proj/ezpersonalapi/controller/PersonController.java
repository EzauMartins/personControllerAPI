package ezau.digitalinnovation.everis.proj.ezpersonalapi.controller;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.MessageResponseDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                         //IndicaControladorAcessadoAtravesDeAPIrest
@RequestMapping("/ApiEz/01/people")     //IndicaLocalDaRequisição(GET)
public class PersonController {

    private PersonRepository personRepository;

    @Autowired //Injetar Implemetação repository
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){ //RequestBody Indica que virá de uma requisição
        // MessageResponseDTO package DTO
        Person savePerson = personRepository.save(person);        //salva inf.Passada em Person no Repository/Banco
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID " + savePerson.getId())
                .build();
    }

}
