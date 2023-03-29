package interview.singleton;

/**
 * @project: x-interview
 * @ClassName: HungrySingleton
 * @author: nzcer
 * @creat: 2023/3/29 13:53
 * @description:
 * 饿汉式单例模式
 * 饿汉模式本身是一种提前创建好实例的方式, 利用jvm 在加载类的时候, 只会加载一次, 以及加载类本身jvm是通过加锁保证线程安全的, 因此饿汉模式将实例作为类的静态变量, 就实现了线程安全的单例.
 * 饿汉式的优点是，在类装载的时候就完成了实例化，避免了线程同步问题;
 * 这样的实现方式不支持延迟加载实例，如果从始至终未使用过这个实例，就会造成内存浪费。
 * 饿汉式在一些场景中无法使用：比如单例类实例的创建是依赖参数或者配置文件的，在通过 getInstance() 方法获取实例对象之前需要调用某个方法设置参数给对象实例，则这种方式将无法使用。
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return singleton;
    }

    private HungrySingleton() {

    }
}
