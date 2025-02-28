package generics.wildcard.upper;

import java.util.ArrayList;
import java.util.List;

class Animal{
    public void speak(){
        System.out.println("I am animal");
    }
}

class Dog extends Animal{
    public void speak(){
        System.out.println("I am dog");
    }
}

class Cat extends Animal{
    public void speak(){
        System.out.println("I am cat");
    }
}

class Puppy extends Dog{
    public void speak(){
        System.out.println("I am puppy");
    }
}

class Upper{
    public List<? extends Dog> getAnimals(){
        List<Puppy> animals1 = new ArrayList<>();// valid
        List<Dog> animals2 = new ArrayList<>();// Valid
        List<Cat> animals3 = new ArrayList<>();// Invalid
        List<Animal> animals4 = new ArrayList<>(animals1);// Invalid
        List<Dog> animals5 = new ArrayList<>(animals1);// Valid
        animals1.add(new Puppy());
        animals2.add(new Dog());
        animals2.add(new Puppy());
        animals3.add(new Cat());
        animals4.addAll(animals2);
        animals4.addAll(animals3);
        animals5.addAll(animals2);
        return animals5;
    }
}

public class Main {
    public static void main(String[] args) {
        Upper upper = new Upper();
        for(Dog animal : upper.getAnimals()){
            animal.speak();
        }
    }
}
