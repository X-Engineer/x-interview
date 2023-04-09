package interview.threadprint.threethreadprint;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @project: x-interview
 * @ClassName: PrintABC
 * @author: nzcer
 * @creat: 2023/4/9 13:09
 * @description:
 * 实现方式二:
 * 使用 Java 内置锁，synchronized + wait + notify 实现
 * 三个线程交替打印 A，B，C
 */

class SyncPrinter {
    private final int maxRound;
    private int curRound = 0;

    public SyncPrinter(int maxRound) {
        this.maxRound = maxRound;
    }

    private final Object lock = new Object();

    public void printA() {
        synchronized (lock) {
            while (curRound < maxRound) {
                if (curRound % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": A");
                    curRound++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            while (curRound < maxRound) {
                if (curRound % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + ": B");
                    curRound++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            while (curRound < maxRound) {
                if (curRound % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + ": C");
                    curRound++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

public class SyncPrintABC {
    public static void main(String[] args) {
        SyncPrinter syncPrinter = new SyncPrinter(30);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        executor.execute(syncPrinter::printA);
        executor.execute(syncPrinter::printB);
        executor.execute(syncPrinter::printC);
        executor.shutdown();
    }
}
