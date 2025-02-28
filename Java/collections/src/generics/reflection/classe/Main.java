package generics.reflection.classe;

import generics.reflection.Person;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
//        1. Method
        Class<?> c1 = Class.forName("generics.reflection.classe.Person");
//        2. Method
        Class<Person> c2 = Person.class;
//        3. Method
        Person p = new Person("Jean", 23);
        Class<?> c3 = p.getClass();
        System.out.println("Class: " + c1.getSimpleName());
        System.out.println("Generic Types: " + Arrays.toString(c2.getTypeParameters()));
        System.out.println("Methods: " + Arrays.toString(c3.getMethods()));
    }
}
