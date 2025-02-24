package observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String msg);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
class ConcreteSubject implements Subject {
    private final ArrayList<Observer> observers = new ArrayList<Observer>();
    String msg;
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        observers.forEach(o -> o.update(msg));
    }
    public void publishMessage(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}

class ConcreteObserver implements Observer {
    String name;
    public ConcreteObserver(String name) {
        this.name = name;
    }
    public void update(String msg) {
        System.out.println(this.name+" Received : "+msg);
    }
}
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("JMV");
        ConcreteObserver observer2 = new ConcreteObserver("Jean");
        ConcreteObserver observer3 = new ConcreteObserver("Vianney");
//        Subscribe
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);
//        Publish
        System.out.println("First message is going to be send..........");
        subject.publishMessage("Hello");
//        Unsubscribe and Subscribe new
        subject.removeObserver(observer1);
        ConcreteObserver observer4 = new ConcreteObserver("Marie");
        subject.registerObserver(observer4);
//        Publish again
        System.out.println("Second message is going to be send..........");
        subject.publishMessage("Bye");
    }
}
