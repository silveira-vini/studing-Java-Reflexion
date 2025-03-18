package ribeiro.silveira.vinicius.studingjavareflexion.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionTransformer {

    public <I, O> O transform(I input, Class<O> targetClass) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> sourceClass = input.getClass();

        O target = targetClass.getDeclaredConstructor().newInstance();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(
                        targetField -> {
                            if (validate(sourceField, targetField)) {
                                try {
                                    targetField.setAccessible(true);
                                    targetField.set(target, sourceField.get(input));
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        })
        );
        return target;
    }

    private boolean validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            return true;
        }
        return false;
    }
}
