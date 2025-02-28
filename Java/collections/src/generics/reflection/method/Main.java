package generics.reflection.method;

import generics.reflection.Person;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?> p = Person.class;
        Method[] methods = p.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
