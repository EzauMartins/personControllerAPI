package ezau.digitalinnovation.everis.proj.ezpersonalapi.dto.request;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class PhoneDTO {


    public Long id;

    @Enumerated(EnumType.STRING)
    public PhoneType type;

    @NotEmpty  ///Anotaçoes do Validation
    @Size(min =13, max = 14)
    public String number;

}
