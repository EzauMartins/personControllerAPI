package ezau.digitalinnovation.everis.proj.ezpersonalapi.repository;

import ezau.digitalinnovation.everis.proj.ezpersonalapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
