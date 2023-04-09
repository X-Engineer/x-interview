package interview.threadprint.threethreadprint;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @project: x-interview
 * @ClassName: BlockingQueuePrintABC
 * @author: nzcer
 * @creat: 2023/3/28 11:06
 * @description:
 * 方式三：
 * 使用 BlockingQueue，我们可以实现线程间的同步和协调，而不需要手动使用锁和条件变量等原语
 * 三个线程交替打印 A，B，C
 */
public class BlockingQueuePrintABC {
    public static void main(String[] args) {
        ThreadTask t1 = new ThreadTask();
        ThreadTask t2 = new ThreadTask();
        ThreadTask t3 = new ThreadTask();

        t1.next = t2;
        t2.next = t3;
        t3.next = t1;

        t1.start();
        t2.start();
        t3.start();

        t1.queue.add(0);
    }
}

/**
 * 继承 Thread 的方式
 */
class ThreadTask extends Thread {
    private static final Integer END = 30;

    public BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public ThreadTask next;

    @Override
    public void run() {
        while (true) {
            Integer take = null;
            try {
                take = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (take >= END) {
                break;
            }
            System.out.println(getName() + ": " + (char) ('A' + take % 3));
            try {
                next.queue.put(take + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (next.isAlive()) {
            try {
                next.queue.put(END);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

