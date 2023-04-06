package interview.twothreadprint.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: x-interview
 * @ClassName: ReentrantLockPrintDemo
 * @author: nzcer
 * @creat: 2023/4/6 21:00
 * @description: reentrant-lock + condition + await + signal 实现线程间通信
 * 在这个示例中，我们使用ReentrantLock创建了一个锁和两个条件（oddCondition和evenCondition）。当一个线程执行printOdd()方法时，它会获取锁，
 * 并在while循环中等待直到isOdd为true。当它打印奇数后，它会将isOdd设置为false，并通过evenCondition.signal()通知printEven()方法继续执行。
 * 同样地，当一个线程执行printEven()方法时，它会获取锁，并在while循环中等待直到isOdd为false。当它打印偶数后，它会将isOdd设置为true，
 * 并通过oddCondition.signal()通知printOdd()方法继续执行。这样，使用ReentrantLock和条件，我们可以实现线程交替打印奇数和偶数，同时减少对synchronized的使用。
 */
class Printer {
    private int num = 1;
    private int maxNum;

    private ReentrantLock lock = new ReentrantLock();

    // 奇数条件
    private Condition oddCondition = lock.newCondition();
    // 偶数条件
    private Condition evenCondition = lock.newCondition();

    // flag = 0 表示偶数，flag = 1 表示奇数
    int flag = 1;
    public Printer(int maxNum) {
        this.maxNum = maxNum;
    }

    // 打印奇数
    public void printOdd() {
        while (num < maxNum) {
            try {
                lock.lock();
                while (flag == 0) {
                    // 当前打印的数是偶数时，阻塞
                    oddCondition.await();
                }
                // 当前打印的数是奇数
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                // 通知打印偶数
                flag = 0;
                evenCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    // 打印偶数
    public void printEven() {
        while (num < maxNum) {
            try {
                lock.lock();
                while (flag == 1) {
                    evenCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                flag = 1;
                oddCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }


}

public class ReentrantLockPrintDemo {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Thread evenThread = new Thread(() -> {
            printer.printEven();
        },"even");
        Thread oddThread = new Thread(() -> {
            printer.printOdd();
        },"odd");
        evenThread.start();
        oddThread.start();
    }
}
