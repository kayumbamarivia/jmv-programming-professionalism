package creational.singleton;
class Singleton {
    private Singleton(){
    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        if(instance1 == instance2){
            System.out.println("Instances are equal");
        }else {
            System.out.println("Instances are not equal");
        }
        Runnable task = ()->{
            Singleton instance3 = Singleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ": " + instance3.hashCode());
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}