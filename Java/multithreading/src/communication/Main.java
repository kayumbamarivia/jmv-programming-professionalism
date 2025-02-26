package communication;
class Communication {
    String message;
    String feedBack;
    boolean messageAvailable = false;
    boolean feedBackAvailable = false;

    synchronized void sendMessage(String message) throws InterruptedException {
        while (messageAvailable) {
            wait();  // Wait if the message is already available
        }
        this.message = message;
        System.out.println(message);
        messageAvailable = true;
        notifyAll();  // Notify the receiver that the message is available
    }

    synchronized void receiveMessage(String feedBack) throws InterruptedException {
        while (!messageAvailable) {
            wait();  // Wait if no message is available to receive
        }
        this.feedBack = feedBack;
        messageAvailable = false;
        feedBackAvailable = true;
        notifyAll();  // Notify the sender that the message has been received
    }

    synchronized void receiveFeedback() throws InterruptedException {
        while (!feedBackAvailable) {
            wait(); // Wait if no feedback is available
        }
        System.out.println(feedBack);
        feedBackAvailable = false;
        notifyAll(); // Notify the sender that the feedback was acknowledged
    }
}

public class Main {
    public static void main(String[] args) {
        Communication communication = new Communication();
        Thread t1 = new Thread(() -> {
            try {
                communication.sendMessage("Hello 👋?");
                communication.receiveFeedback();
                communication.sendMessage("How are you?");
                communication.receiveFeedback();
                communication.sendMessage("Great, Have a nice day!");
                communication.receiveFeedback();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                communication.receiveMessage("Hi 👋");
                communication.receiveMessage("I am fine 👍, What about you?");
                communication.receiveMessage("You too🙏, Bye👋");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();
    }
}
