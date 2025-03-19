package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Cpf;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Person;
import ribeiro.silveira.vinicius.studingjavareflexion.service.ObjectToJson;

import static org.junit.jupiter.api.Assertions.*;

class ObjectToJsonTest {

    private final Person person = new Person(1L, "Vinicius", 38, new Cpf("021.900.541-92"));

    @Test
    void shouldConvertObjectToJson() {
        ObjectToJson objectToJson = new ObjectToJson();
        String json = objectToJson.convert(person);
        System.out.println(json);
        Assertions.assertInstanceOf(String.class, json);
    }
}