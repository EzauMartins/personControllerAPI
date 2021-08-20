package ezau.digitalinnovation.everis.proj.ezpersonalapi.entity;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data                                   // GETTER AND SETTER
@Builder                                // Contruçao de Objetos Person.builder().name("Adam Savage").city("San Francisco")...
@AllArgsConstructor                     // Contrutores
@NoArgsConstructor                      // Contrutores

public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PhoneType type;

    @Column(nullable = false)
    public String number;
}
