package ribeiro.silveira.vinicius.studingjavareflexion.model;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Component
public class Person {

    private Long id;
    private String name;
    private int age;
    private Cpf cpf;

}
