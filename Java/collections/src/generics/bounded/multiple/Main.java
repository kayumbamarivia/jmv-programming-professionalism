package generics.bounded.multiple;

class Printer{
    void print1(){
        System.out.println("Printing from Printer class");
    }
}

interface Printable{
    void print();
}

class MyPrinter extends Printer implements Printable {
    private Printable printable;
    public MyPrinter(Printable printable) {
        this.printable = printable;
    }
    public void print(){
        printable.print();
    }

    public void setPrintable(Printable printable) {
        this.printable = printable;
    }

    public Printable getPrintable() {
        return printable;
    }
}
class BoundedPrinter<T extends Printer & Printable, N>{
    private N bound;
    private T printer;
    BoundedPrinter(N bound, T printer){
        this.bound = bound;
        this.printer = printer;
    }
    public N getBound(){
        return bound;
    }

    public T getPrinter() {
        return printer;
    }

    public void setPrinter(T printer) {
        this.printer = printer;
    }

    public void setBound(N bound){
        this.bound = bound;
    }
}
public class Main {
    public static void main(String[] args) {
        MyPrinter p1 = new MyPrinter(()-> System.out.println("Printing from my Printable interface 1"));
        MyPrinter p2 = new MyPrinter(()-> System.out.println("Printing from my Printable interface 2"));
        Printer printer = new Printer();
        p1.print();
        p2.print();
        p2.print1();
        printer.print1();
        BoundedPrinter<MyPrinter, String> bounder = new BoundedPrinter<>("Hello", p1);
        System.out.println(bounder.getBound());
        bounder.getPrinter().setPrintable(()-> System.out.println("Printing from my Printable interface 3"));
        bounder.getPrinter().getPrintable().print();
    }
}
