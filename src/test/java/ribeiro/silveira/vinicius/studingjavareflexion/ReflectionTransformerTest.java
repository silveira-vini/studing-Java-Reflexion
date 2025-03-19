package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Address;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Cpf;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.model.PersonDTO;
import ribeiro.silveira.vinicius.studingjavareflexion.service.ReflectionTransformer;

import java.lang.reflect.InvocationTargetException;

@SpringBootTest
public class ReflectionTransformerTest {

    private final Person person = new Person(1L, "Vinicius Silveira", 38, new Cpf("021.900.541-92"));
    private final Address address = new Address("St. Louis", 20, "New York");

    @Test
    public void shouldConvertPersonToPersonDTO() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        PersonDTO personDTO = new ReflectionTransformer().transform(person);
        Assertions.assertInstanceOf(PersonDTO.class, personDTO);
        Assertions.assertEquals(personDTO.getName(), person.getName());
        Assertions.assertEquals(personDTO.getAge(), person.getAge());
        Assertions.assertEquals(personDTO.getCpf(), person.getCpf());
    }

    @Test
    public void shouldNotFoundClassDTO() {
        Assertions.assertThrows(ClassNotFoundException.class,
                () -> new ReflectionTransformer().transform(address));
    }

}


