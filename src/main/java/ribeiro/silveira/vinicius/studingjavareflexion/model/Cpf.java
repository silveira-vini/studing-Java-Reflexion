package ribeiro.silveira.vinicius.studingjavareflexion.model;

import ribeiro.silveira.vinicius.studingjavareflexion.exception.InvalidCpfException;

public record Cpf(String cpf) {

    public Cpf(String cpf) {
        if (validate(cpf)) {
            this.cpf = cpf;
        } else {
            throw new InvalidCpfException("CPF inválido");
        }
    }

    public static boolean validate(String cpf) {
        // código de validação de CPF brasileiro
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) {
            return false;
        }
        boolean allDigitsEqual = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstCheckDigit = 11 - (sum % 11);
        if (firstCheckDigit >= 10) {
            firstCheckDigit = 0;
        }
        if (Character.getNumericValue(cpf.charAt(9)) != firstCheckDigit) {
            return false;
        }
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int secondCheckDigit = 11 - (sum % 11);
        if (secondCheckDigit >= 10) {
            secondCheckDigit = 0;
        }
        return Character.getNumericValue(cpf.charAt(10)) == secondCheckDigit;
    }
}
