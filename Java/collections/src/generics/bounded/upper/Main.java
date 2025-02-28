package generics.bounded.upper;
class Printer{
    void print(){
        System.out.println("Printing upper object");
    }
}
class BoundedPrinter<T extends Printer, N>{
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
        Printer p1 = new Printer();
        Printer p2 = new Printer();
        p1.print();
        p2.print();
        BoundedPrinter<Printer, String> bounder = new BoundedPrinter<>("Hello", p1);
        System.out.println("Bound : "+bounder.getBound());
        bounder.getPrinter().print();
    }
}
