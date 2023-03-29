package interview.singleton;

/**
 * @project: x-interview
 * @ClassName: LazySingleton
 * @author: nzcer
 * @creat: 2023/3/29 13:56
 * @description:
 * 懒汉式单例模式
 * 懒加载，实现方式是线程不安全的，如果有两个线程同时进入到 getInstance() 方法，并且正好都通过了判断语句，这时便会产生多个实例。通常不建议在生产环境中使用线程不安全的懒汉式创建单例类
 */
public class LazySingleton {
    private static LazySingleton singleton;

    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
    private LazySingleton() {

    }
}
