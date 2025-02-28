package generics.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Resource <T> {
    private T data;
    public Resource(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
public class Main {
    public static void main(String[] args) {
        Resource<String> r1 = new Resource<String>("Hello");
        Resource<Integer> r2 = new Resource<Integer>(12);
        Resource<String> r3 = new Resource<String>("World");
        List<String> list1 = new ArrayList<String>(List.of(r1.getData(),r3.getData()));
        List<?> list2 = new ArrayList<>(Arrays.asList(r1.getData(),r2.getData()));
        System.out.println(r1.getData());
        System.out.println(r2.getData());
        System.out.println(r3.getData());
        System.out.println(list1);
        System.out.println(list2);
    }
}