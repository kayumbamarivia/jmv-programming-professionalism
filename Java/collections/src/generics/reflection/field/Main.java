package generics.reflection.field;

import generics.reflection.Person;
import java.lang.reflect.Field;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Person p = new Person("Jean", 30);
        Class<?> c = p.getClass();
        for (Field f : c.getDeclaredFields()) {
            System.out.println(f.getName());
        }
    }
}
