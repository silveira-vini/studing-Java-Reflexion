package ribeiro.silveira.vinicius.studingjavareflexion.refl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformer {

    public <T, U> U transform(T source, Class<U> target) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> sourceClass = source.getClass();
        Constructor<U> constructor = target.getDeclaredConstructor(
                target.getDeclaredFields()[0].getType(),
                target.getDeclaredFields()[1].getType(),
                target.getDeclaredFields()[2].getType()
        );

        U instanceOfTarget = constructor.newInstance(
                getValue(source, sourceClass, target.getDeclaredFields()[0].getName()),
                getValue(source, sourceClass, target.getDeclaredFields()[1].getName()),
                getValue(source, sourceClass, target.getDeclaredFields()[2].getName())
        );

        return instanceOfTarget;
    }

    private <T> Object getValue(T source, Class<?> sourceClass, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field sourceField = sourceClass.getDeclaredField(fieldName);
        sourceField.setAccessible(true);
        return sourceField.get(source);
    }
}