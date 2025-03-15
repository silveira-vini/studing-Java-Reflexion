package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.refl.Transformer;
import ribeiro.silveira.vinicius.studingjavareflexion.repository.PersonRepository;
import ribeiro.silveira.vinicius.studingjavareflexion.service.DTO.PersonDTO;

import java.lang.reflect.InvocationTargetException;

@SpringBootTest
class StudyingJavaReflexionApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldTransform() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        PersonRepository personRepository = new PersonRepository();
        Transformer transformer = new Transformer();
        Person person = personRepository.list();
        PersonDTO transformed = transformer.transform(person, PersonDTO.class);

        Assertions.assertInstanceOf(PersonDTO.class, transformed);
        Assertions.assertEquals("Vinicius Silveira", transformed.name());
        Assertions.assertEquals(38, transformed.age());
        Assertions.assertEquals("021.800.531-92", transformed.cpf());

    }

}
