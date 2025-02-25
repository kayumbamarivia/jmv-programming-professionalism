package lambda;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.BiFunction;
@java.lang.FunctionalInterface
interface FunctionalInterface{
    void functionalMethod(String name);
    static void getClassName(){
        System.out.println("class name 1 from Class is "+FunctionalInterface.class.getName());
        System.out.println("class name 2 from Thread class is "+Thread.currentThread().getName());
    }
    default void greet(String name){
        System.out.println("Hello"+" "+name);
    }
}
public class Main {
    public static void main(String[] args) {
//        Old fashion without lambda expression
        System.out.println("Old fashion ");
        FunctionalInterface fi = new FunctionalInterface() {
            public void functionalMethod(String name) {
                System.out.println("Hello "+name);
            }
        };
        fi.functionalMethod("JMV");
//        Using lambda expression
        System.out.println("\nNew fashion using lambda ");
        FunctionalInterface fi2 = name -> System.out.println("Hello "+name);
        FunctionalInterface fi3 = System.out::println;
        fi2.functionalMethod("JMV");
        fi3.functionalMethod("Hello JMV");
//        Calling default method from interface
        System.out.println("\nCalling default method from interface");
        fi.greet("JMV");
//        Calling static method from interface
        System.out.println("\nCalling static method from interface");
        FunctionalInterface.getClassName();
//        Lambda functions with Stream api
        List<String> list = Arrays.asList("alice", "aline", "Betty");
        List<String> startsWithB = list.stream().filter((str)->str.startsWith("B")).collect(Collectors.toList());
        System.out.println(startsWithB);
//        Builtin-Functional interfaces
        System.out.println("\n Built-in Function interfaces ");
        BiFunction<Integer,Integer, Integer> add = Integer::min;
        BiFunction<String, String, String> concat1 = String::concat;
        BiFunction<String, String, String> concat2 = (a,b) -> a+" "+b;
        System.out.println(add.apply(10,5));
        System.out.println(concat1.apply( "Jean", "Marie"));
        System.out.println(concat2.apply( "Jean", "Marie"));
    }
}