package ezau.digitalinnovation.everis.proj.ezpersonalapi.service;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.MessageResponseDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) { //RequestBody Indica que virá de uma requisição
        // MessageResponseDTO package DTO
        Person savePerson = personRepository.save(person);        //salva inf.Passada em Person no Repository/Banco
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID " + savePerson.getId())
                .build();

    }

}
