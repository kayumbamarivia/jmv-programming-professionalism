package creational.builder;

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "data = { " +
                "\"name\": \"" + name + "\", " +
                "\"age\": \"" + age + "\" " +
                "}";
    }
}

class Builder{
    private final Person person;
    public Builder(){
        person = new Person();
    }
    public Builder name(String name){
        person.setName(name);
        return this;
    }
    public Builder age(int age){
        person.setAge(age);
        return this;
    }
    public Person build(){
        return person;
    }
}

public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Person person = builder.name("JVM").age(19).build();
        System.out.println(person);
    }
}
