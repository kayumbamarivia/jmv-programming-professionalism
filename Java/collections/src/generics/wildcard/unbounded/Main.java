package generics.wildcard.unbounded;
import java.util.ArrayList;
import java.util.List;
class Animal{
    public void speak(){
        System.out.println("I'm an animal");
    }
}
class Dog extends Animal{
    public void speak(){
        System.out.println("I'm a dog");
    }
}
class Cat extends Animal{
    public void speak(){
        System.out.println("I'm a cat");
    }
}
class Puppy extends Dog{
    public void speak(){
        System.out.println("I'm a puppy");
    }
}

class Unbounded{
    public void getAnimals(List<?> animals) {
        for (Object animal : animals) {
            if (animal instanceof Animal a) {
                a.speak();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
       Puppy puppy = new Puppy();
        List<Animal> animals = List.of(animal, dog, cat, puppy);
        List<Dog> dogs = List.of(dog);
        List<Dog> dogsAndPuppies = List.of(puppy,dog);
        List<Cat> cats = List.of(cat);
        List<Puppy> puppies = List.of(puppy);
        Unbounded bounder = new Unbounded();
        System.out.println("========= <?> allows any type ===============");
        System.out.println("============= Animals ===================");
        bounder.getAnimals(animals);
        System.out.println("\n============= Dogs =============");
        bounder.getAnimals(dogs);
        System.out.println("\n============= Dogs and puppies ============");
        bounder.getAnimals(dogsAndPuppies);
        System.out.println("\n============= Puppies ================");
        bounder.getAnimals(puppies);
        System.out.println("\n=============== Cats ========================");
        bounder.getAnimals(cats);
    }
}
