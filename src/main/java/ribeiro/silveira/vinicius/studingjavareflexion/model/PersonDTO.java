package ribeiro.silveira.vinicius.studingjavareflexion.model;

public class PersonDTO {

    private String name;
    private int age;
    private String cpf;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
