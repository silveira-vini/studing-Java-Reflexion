package ribeiro.silveira.vinicius.studingjavareflexion.repository;

import org.springframework.stereotype.Repository;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Cpf;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;

@Repository
public class PersonRepository {

    public Person list() {
        return new Person(1L, "Vinicius Silveira", 38,  new Cpf("021.900.541-93"));
    }


}
