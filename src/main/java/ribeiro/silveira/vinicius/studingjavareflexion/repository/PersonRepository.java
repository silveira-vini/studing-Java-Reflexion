package ribeiro.silveira.vinicius.studingjavareflexion.repository;

import org.springframework.stereotype.Repository;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;

@Repository
public class PersonRepository {

    public Person list() {
        return new Person(1L, "Vinicius Silveira", 38,  "021.800.531-92");
    }
}
