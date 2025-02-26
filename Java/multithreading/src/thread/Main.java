package thread;
class CommonTask{
    public static void printNumbers(String threadName){
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName+" is executing "+i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }System.out.println(threadName+" Finished executing "+i);
        }
    }
}
class Mythread extends Thread {
    public void run() {
       CommonTask.printNumbers("Thread");
    }
}

class MyRunnable implements Runnable {
    public void run() {
      CommonTask.printNumbers("Runnable");
    }
}

public class Main {
    public static void main(String[] args) {
//        CommonTask.printNumbers("Main");
        Mythread mythread = new Mythread();
//        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(()->CommonTask.printNumbers("Runnable"));
        mythread.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        mythread.start();
    }
}
