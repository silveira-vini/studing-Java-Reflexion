package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ribeiro.silveira.vinicius.studingjavareflexion.model.PersonDTO;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.repository.PersonRepository;
import ribeiro.silveira.vinicius.studingjavareflexion.service.ReflectionTransformer;

import java.lang.reflect.InvocationTargetException;

@SpringBootTest
public class ReflectionTransformerTest {

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        PersonRepository personRepository = new PersonRepository();
    }

    @Test
    public void shouldConvertPersonToPersonDTO() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person person = personRepository.list();
        ReflectionTransformer reflectionTransformer = new ReflectionTransformer();
        PersonDTO personDtoTransformed = reflectionTransformer.transform(person);
        Assert.isInstanceOf(PersonDTO.class, personDtoTransformed);
    }

}


