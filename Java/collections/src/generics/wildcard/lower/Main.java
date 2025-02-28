package generics.wildcard.lower;
import java.util.ArrayList;
import java.util.List;

class Animal {
    public void speak(){
        System.out.println("I am animal");
    }
}
class Dog extends Animal {
    public void speak(){
        System.out.println("I am dog");
    }
}
class Cat extends Animal {
    public void speak(){
        System.out.println("I am cat");
    }
}

class Puppy extends Dog{
    public void speak(){
        System.out.println("I am puppy");
    }
}

class Lower{
    public void getAnimals(List<? super Dog> animals ){
        for(Object animal : animals){
            if(animal instanceof Animal a){
                a.speak();
            }
        }
    }
    public List<? super Dog> getAnimals(){
        List<Puppy> animals1 = new ArrayList<>();// Invalid
        List<Dog> animals2 = new ArrayList<>();// Valid
        List<Cat> animals3 = new ArrayList<>();// Invalid
        List<Animal> animals4 = new ArrayList<>(animals1);
        animals1.add(new Puppy());
        animals2.add(new Dog());
        animals2.add(new Puppy());
        animals3.add(new Cat());
        animals4.addAll(animals2);
        animals4.addAll(animals3);
        return animals4;
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
        Lower lower = new Lower();
        System.out.println("========= <? super T> restricts a type to T and its Super types===============");
        System.out.println("============= Animals that are Dogs since Animal is a super type of Dog ===================");
        lower.getAnimals(animals);
        System.out.println("\n============= Dogs are always Dogs =============");
        lower.getAnimals(dogs);
        System.out.println("\n============= Dogs and puppies are Dogs since Dog is a Parent of Cat ============");
        lower.getAnimals(dogsAndPuppies);
        System.out.println("\n============= Puppies are subclass of Dogs, so it will give compiler ================");
//        lower.getAnimals(puppys);
        System.out.println("\n=============== Cats are neither Dogs nor their super type, It will give compile error ========================");
//        lower.getAnimals(cats);
        System.out.println("\n========= Using get animals method which return them ===========");
        System.out.println("\n============== Animal List ================");
        for(Object os : lower.getAnimals()){
            if(os instanceof Animal a){
                a.speak();
            }
        }
    }
}
