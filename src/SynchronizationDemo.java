class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
        }
        System.out.println();
    }
}

public class SynchronizationDemo{
    public static void main(String[] args) throws InterruptedException {

        Table obj = new Table();

        Thread t1 = new Thread() {
            public void run() {
                obj.printTable(5);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                obj.printTable(100);
            }
        };

        t1.start();
        t1.join();   // ensures first completes fully

        t2.start();
        t2.join();   // ensures second completes fully
    }
}