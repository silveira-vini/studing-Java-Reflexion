package ribeiro.silveira.vinicius.studingjavareflexion.service;

import org.springframework.stereotype.Service;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.model.PersonDTO;
import ribeiro.silveira.vinicius.studingjavareflexion.repository.PersonRepository;

import java.lang.reflect.InvocationTargetException;

@Service
public class PersonService {

    public PersonDTO list() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Person person = new PersonRepository().list();
        return new ReflectionTransformer().transform(person);
    }
}
