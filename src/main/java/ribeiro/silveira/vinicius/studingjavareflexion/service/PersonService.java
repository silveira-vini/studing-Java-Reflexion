package ribeiro.silveira.vinicius.studingjavareflexion.service;

import org.springframework.stereotype.Service;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.service.DTO.PersonDTO;

@Service
public class PersonService {

    public PersonDTO list(Person person) {
        return new PersonDTO(person.getName(), person.getCpf());
    }
}
