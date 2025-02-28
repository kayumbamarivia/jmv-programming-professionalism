package generics.reflection.generic;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

class A<B,C,D>{
    public B b;
    public A(B b){
        this.b = b;
        System.out.println("A Constructor Called");
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> a = Class.forName("generics.reflection.generic.A");
        TypeVariable<?> type = a.getTypeParameters()[2];
        System.out.println(type);
        for(TypeVariable<?> t : a.getTypeParameters() ) {
            System.out.println(t);
        }
    }
}
