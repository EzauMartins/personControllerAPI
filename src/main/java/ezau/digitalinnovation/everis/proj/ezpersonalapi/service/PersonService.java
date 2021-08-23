package ezau.digitalinnovation.everis.proj.ezpersonalapi.service;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.MessageResponseDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.request.PersonDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.exception.PersonNotFoundException;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.mapper.PersonMapper;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired)) // Substitue Construtor
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

//    @Autowired
//    public PersonService(PersonRepository personRepository) { // Contrutor
//        this.personRepository = personRepository;
//    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) { //RequestBody Indica que virá de uma requisição
        // MessageResponseDTO package DTO

        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);        //salva inf.Passada em Person no Repository/Banco
        return createMessageResponse(savePerson.getId(), "Created Person with ID ");

    }

    public List<PersonDTO> listAll() {
        List <Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = VerifyIfExists(id);

        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        VerifyIfExists(id);

        personRepository.deleteById(id);
    }



    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        VerifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatePerson = personRepository.save(personToUpdate);        //salva inf.Passada em Person no Repository/Banco
        return createMessageResponse(updatePerson.getId(), "Update Person with ID ");

    }

    private Person VerifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}

