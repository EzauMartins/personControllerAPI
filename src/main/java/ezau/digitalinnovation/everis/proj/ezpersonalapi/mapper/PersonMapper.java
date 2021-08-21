package ezau.digitalinnovation.everis.proj.ezpersonalapi.mapper;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.request.PersonDTO;
import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface PersonMapper {     /// PRECISA SER INTERFACE
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);



}
