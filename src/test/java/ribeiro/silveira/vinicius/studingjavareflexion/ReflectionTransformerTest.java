package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.model.PersonDTO;
import ribeiro.silveira.vinicius.studingjavareflexion.repository.PersonRepository;
import ribeiro.silveira.vinicius.studingjavareflexion.service.PersonService;

import java.lang.reflect.InvocationTargetException;

@SpringBootTest
public class ReflectionTransformerTest {

    private final Person person = new PersonRepository().list();

    @Test
    public void shouldConvertPersonToPersonDTO() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PersonDTO personDTO = new PersonService().list();
        Assertions.assertInstanceOf(PersonDTO.class, personDTO);
        Assertions.assertEquals(personDTO.getName(), person.getName());
        Assertions.assertEquals(personDTO.getAge(), person.getAge());
        Assertions.assertEquals(personDTO.getCpf(), person.getCpf());
    }

}


