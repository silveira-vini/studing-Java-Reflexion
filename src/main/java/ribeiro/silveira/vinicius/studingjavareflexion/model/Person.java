package ribeiro.silveira.vinicius.studingjavareflexion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {

    private Long id;
    private String name;
    private int age;
    private Cpf cpf;

}
