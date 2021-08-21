package ezau.digitalinnovation.everis.proj.ezpersonalapi.service;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.MessageResponseDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.request.PersonDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.mapper.PersonMapper;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) { //RequestBody Indica que virá de uma requisição
        // MessageResponseDTO package DTO

        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);        //salva inf.Passada em Person no Repository/Banco
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID " + savePerson.getId())
                .build();

    }

    public List<PersonDTO> listAll() {
        List <Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
