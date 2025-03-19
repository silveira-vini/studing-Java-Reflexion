package ribeiro.silveira.vinicius.studingjavareflexion.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionTransformer {

    public <I, O> O transform(I input) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    if (validate(sourceField, targetField)) {
                        sourceField.setAccessible(true);
                        targetField.setAccessible(true);
                        try {
                            targetField.set(targetClass, sourceField.get(input));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }));
        return targetClass;
    }

    private boolean validate(Field sourceField, Field targetField) {
        return sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType());
    }
}
