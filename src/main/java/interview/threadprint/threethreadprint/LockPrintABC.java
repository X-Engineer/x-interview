package interview.threadprint.threethreadprint;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: x-interview
 * @ClassName: LockPrintABC
 * @author: nzcer
 * @creat: 2023/4/9 12:44
 * @description:
 * 实现方式一:
 * 使用显式锁和条件原语 ，lock + await + signal 通知机制实现
 * 三个线程交替打印 A，B，C
 */
class Printer {
    private final int totalRound;
    private int curRound = 0;

    public Printer(int totalRound) {
        this.totalRound = totalRound;
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition aCondition = lock.newCondition();
    private Condition bCondition = lock.newCondition();
    private Condition cCondition = lock.newCondition();

    /**
     * 打印字母 A
     */
    public void printA() {
        while (curRound <= totalRound) {
            try {
                lock.lock();
                // 未到打印 A 的时机
                while (curRound % 3 != 0) {
                    aCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": A");
                // 打印完 A 通知打印 B
                curRound++;
                bCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 打印字母 B
     */
    public void printB() {
        while (curRound <= totalRound) {
            try {
                lock.lock();
                // 未到打印 B 的时机
                while (curRound % 3 != 1) {
                    bCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": B");
                // 打印完 B 通知打印 C
                curRound++;
                cCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 打印字母 C
     */
    public void printC() {
        while (curRound <= totalRound) {
            try {
                lock.lock();
                // 未到打印 C 的时机
                while (curRound % 3 != 2) {
                    cCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": C");
                // 打印完 C 通知打印 A
                curRound++;
                aCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockPrintABC {
    public static void main(String[] args) {
        Printer printer = new Printer(30);
        Runnable aRun = () -> printer.printA();
        Runnable bRun = () -> printer.printB();
        Runnable cRun = () -> printer.printC();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        executor.execute(aRun);
        executor.execute(bRun);
        executor.execute(cRun);
        executor.shutdown();
    }
}
