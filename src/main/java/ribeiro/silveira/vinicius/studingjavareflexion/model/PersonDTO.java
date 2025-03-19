package ribeiro.silveira.vinicius.studingjavareflexion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String name;
    private int age;
    private Cpf cpf;


}
