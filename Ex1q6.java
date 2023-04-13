public class Ex1q6 implements Runnable {
    public volatile static int counter = 0;
    static final int ITERATIONS = 1000000;

    public static void main(String[] args) {
        int n;
        Ex1q6 ex = new Ex1q6();

        try {
            n = Integer.parseInt(args[0]);
            counter = 0;
        } catch (Exception e) {
            System.out.println("Wrong Input");
            return;
        }

        Thread[] threads = new Thread[n];
        
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(ex);
        }

        long start = System.currentTimeMillis();

        // start the threads
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }

        // waiting for the threads to end
        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        System.out.format("Finished after %d miliseconds. The counter is: %d, Number of threads: %d\n",
                (System.currentTimeMillis() - start), counter, n);
    }

    @Override
    public void run() {
        for (int temp, i = 0; i < ITERATIONS; ++i) {
            temp = counter;
            ++temp;
            counter = temp;
        }
    }
}
