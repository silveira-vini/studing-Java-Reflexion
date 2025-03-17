package ribeiro.silveira.vinicius.studingjavareflexion.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionTransformer {

    public <I, O> O transform(I input) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class<?> sourceClass = input.getClass();
        Class<?> target = Class.forName(sourceClass + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(
                        targetField -> {
                            validate(sourceField, targetField);
                            try {
                                targetField.set(targetClass, sourceField.get(input));
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        })
        );
        return targetClass;
    }

    private void validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }
}
