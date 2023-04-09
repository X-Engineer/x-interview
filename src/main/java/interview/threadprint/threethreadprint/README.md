经典手撕题: 三个线程交替打印 A，B，C
- 通过 synchronized + wait + notify 实现（Java 内置锁）
- 通过 lock + condition + await + signal 实现（通过使用条件原语，我们可以在等待条件时暂停线程的执行，避免了不必要的循环等待）
- 通过 BlockingQueue 实现（通过使用线程安全的阻塞队列，我们不需要手动使用锁和条件变量等原语）