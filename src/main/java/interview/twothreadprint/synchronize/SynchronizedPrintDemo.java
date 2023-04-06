package interview.twothreadprint.synchronize;

/**
 * @project: x-interview
 * @ClassName: SynchronizedPrintDemo
 * @author: nzcer
 * @creat: 2023/4/6 20:48
 * @description:
 * synchronized + wait + notify 来实现线程间相互通信
 * 在下面的代码中，Printer类有两个方法：printOdd()和printEven()。当一个线程执行printOdd()方法时，它会打印奇数，
 * 而当另一个线程执行printEven()方法时，它会打印偶数。在每次打印后，它会通过notify()方法通知另一个线程继续执行。
 * 如果没有打印，则该线程会在wait()方法上等待。这样，两个线程就可以交替打印奇数和偶数了。
 */
class Printer {
    int num = 1;
    int maxNum;

    public Printer(int maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * 打印奇数
     */
    public synchronized void printOdd() {
        while (num <= maxNum) {
            if (num % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                // 通知打印偶数的线程
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印偶数
     */
    public synchronized void printEven() {
        while (num <= maxNum) {
            if (num % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                // 通知打印奇数的线程
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class SynchronizedPrintDemo {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Thread oddThread = new Thread(() -> {
            printer.printOdd();
        }, "Odd");

        Thread evenTread = new Thread(() -> {
            printer.printEven();
        },"Even");

        oddThread.start();
        evenTread.start();
    }
}
