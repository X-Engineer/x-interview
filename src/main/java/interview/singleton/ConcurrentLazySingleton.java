package interview.singleton;

/**
 * @project: x-interview
 * @ClassName: ConcurrentLazySingleton
 * @author: nzcer
 * @creat: 2023/3/29 13:59
 * @description:
 */
public class ConcurrentLazySingleton {
    private static volatile ConcurrentLazySingleton singleton;

    /**
     * 为了做到线程安全，可以给 getInstance() 方法加一把锁。
     * 但是，由于加锁的粒度较大，实际的效率非常低。
     * 如果这个单例类偶尔会被使用到，那这种实现方式还可以接受。但是，如果频繁地用到，那频繁加锁、释放锁则会出现并发度低的问题，造成性能瓶颈
     * @return
     */
    //public static synchronized ConcurrentLazySingleton getInstance() {
    //    if (singleton == null) {
    //        singleton = new ConcurrentLazySingleton();
    //    }
    //    return singleton;
    //}

    /**
     *
     * 双重检测的实现方式是一种既支持延迟加载、又支持高并发的单例实现方式
     * 同步方法效率低，那我们考虑使用同步代码块来实现
     * 当有两个线程同时进入到 getInstance() 方法时，虽然会出现都通过次检查的判断语句，但是只会有一个线程获得锁并实例化对象，
     * 即使后续再有线程进入到同步代码块中，也会被第二次检查的判断语句挡在外面。
     * @return
     */
    public static ConcurrentLazySingleton getInstance() {
        // 一次检测
        if (singleton == null) {
            synchronized (ConcurrentLazySingleton.class) {
                // 二次检测
                if (singleton == null) {
                    singleton = new ConcurrentLazySingleton();
                }
            }
        }
        return singleton;
    }

    private ConcurrentLazySingleton() {

    }
}
