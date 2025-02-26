package threadpool;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
class Task implements Runnable {
    int taskId;
    public Task (int taskId){
        this.taskId = taskId;
    }
    public void run() {
        System.out.println("Task " + taskId+" is running on "+Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.fillInStackTrace();
        }
        System.out.println("Task " + taskId+" is finished on "+Thread.currentThread().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(5)){
            for (int i = 0; i < 5; i++) {
                int taskId = i;
                executor.execute(()->{
                    System.out.println("Task " + taskId+" is running on "+Thread.currentThread().getName());
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        e.fillInStackTrace();
                    }
                    System.out.println("Task " + taskId+" is finished on "+Thread.currentThread().getName());
                });
            }
            executor.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}