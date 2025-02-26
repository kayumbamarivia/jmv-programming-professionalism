//package deadlock;
//
//class Resource {
//    synchronized void method1(Resource r) {
//        System.out.println(Thread.currentThread().getName()+" Acquired lock on "+this);
//        try {Thread.sleep(2000);}catch(InterruptedException e) {}
//        r.method2();
//        }
//    synchronized void method2() {
//        System.out.println(Thread.currentThread().getName()+" Acquired lock on "+this);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Resource r1 = new Resource();
//        Resource r2 = new Resource();
//        Thread t1 = new Thread(() -> r1.method1(r2), "Thread-1");
//        Thread t2 = new Thread(() -> r2.method1(r1), "Thread-2");
//        t1.start();
//        t2.start();
//    }
//}

package deadlock;

class Resource {
    void method(Resource r) {
        Resource first = this.hashCode() < r.hashCode() ? this : r;
        Resource second = this.hashCode() < r.hashCode() ? r : this;
        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " Acquired lock on " + first);
            try { Thread.sleep(2000); } catch (InterruptedException e) {}

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " Acquired lock on " + second);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();
        Thread t1 = new Thread(() -> r1.method(r2), "Thread-1");
        Thread t2 = new Thread(() -> r2.method(r1), "Thread-2");
        t1.start();
        t2.start();
    }
}
