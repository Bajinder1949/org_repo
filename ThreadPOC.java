public class ThreadPOC {

    // Method 1: Extend Thread class
    static class MyThread extends Thread {
        private String threadName;

        public MyThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Count: " + i);
                try {
                    Thread.sleep(500); // Pause for 0.5 sec
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupted.");
                }
            }
        }
    }

    // Method 2: Implement Runnable interface
    static class MyRunnable implements Runnable {
        private String threadName;

        public MyRunnable(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupted.");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Thread using Thread class
        MyThread thread1 = new MyThread("Thread-1");

        // Thread using Runnable interface
        Thread thread2 = new Thread(new MyRunnable("Thread-2"));

        // Start both threads
        thread1.start();
        thread2.start();

        // Main thread also runs something
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
    }
}
