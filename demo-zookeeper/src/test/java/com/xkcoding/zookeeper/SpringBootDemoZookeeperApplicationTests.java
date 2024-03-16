package com.xkcoding.zookeeper;

import com.xkcoding.zookeeper.annotation.ZooLock;
import com.xkcoding.zookeeper.aspectj.ZooLockAspect;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * zookeeper是为分布式应用提供一致性服务的软件，可以用zookeeper实现分布式锁
 * 使用AOP实现分布式锁的具体做法是：
 * 在应用的特定业务方法前后 织入 获取和释放 分布式锁的逻辑
 * 这样就可以在整个方法执行期间保持对资源的独占访问，而无需在每个业务方法中手动编写加解锁代码，
 * 增强了代码的复用性和整洁性。
 * 总结来说，分布式锁是一种跨节点的同步机制，而AOP分布式锁是将分布式锁的使用以声明式编程的方式融入到应用系统的具体实现手段
 * 分布式锁是一种跨节点同步机制，而AOP分布式锁是一种实现手段。
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootDemoZookeeperApplicationTests {

    public Integer getCount() {
        return count;
    }

//    private Integer count = 10000;
    private Integer count = 1000;
    private ExecutorService executorService = Executors.newFixedThreadPool(1000); // 线程池 java.util.concurrent.ThreadPoolExecutor@304d0259

    /*
    * @Autowired注解在有多个实现类的接口上时。
    * 1. Spring首先按类型查找：容器中是否存在与注解接口类型匹配的唯一 Bean 对象。如果找到，将该唯一的 Bean 对象赋值给该属性。
    * 2. 如果容器中存在多个该类型的唯一 Bean 对象，Spring 会再根据该 `属性名` 去容器中查找：看看容器中的哪个 Bean 对象的 id 值和该属性名一致
    * CuratorFramework 是 Apache Curator 库中的一个核心接口，它提供了一种简单的方法来与 Apache ZooKeeper 交互.
    * */

    @Autowired
    private CuratorFramework zkClient; // 只有一个实现类时：org.apache.curator.framework.imps.CuratorFrameworkImpl

    /**
     * 不使用分布式锁，程序结束查看count的值是否为0，即便在count=1000的时候，最后count的值也有极大概率不为0
     */
    @Test
    public void test() throws InterruptedException {
//        IntStream.range(0, 10000).forEach(i -> executorService.execute(this::doBuy));
        IntStream.range(0, 1000).forEach(i -> executorService.execute(this::doBuy)); // 相当于一个while循环
        TimeUnit.MINUTES.sleep(1);
        log.error("count值为{}", count);
    }

    /**
     * 测试AOP分布式锁，最后count值一定为0
     * 这里为什么叫AOP分布式锁？ 为什么是AOP？相当于所有经过这个切面的都会上分布式锁？
     */
    @Test
    public void testAopLock() throws InterruptedException {
        // 测试类中使用AOP需要手动代理，需要结合@ZooLock注解
        SpringBootDemoZookeeperApplicationTests target = new SpringBootDemoZookeeperApplicationTests();
        AspectJProxyFactory factory = new AspectJProxyFactory(target); // AOP手动代理的体现，AOP与代理模式密切相关
        ZooLockAspect aspect = new ZooLockAspect(zkClient);
        factory.addAspect(aspect);
        SpringBootDemoZookeeperApplicationTests proxy = factory.getProxy();

//        IntStream.range(0, 10000).forEach(i -> executorService.execute(() -> proxy.aopBuy(i)));
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> proxy.aopBuy(i)));
        TimeUnit.MINUTES.sleep(1);
        log.error("count值为{}", proxy.getCount());
    }

    /**
     * 测试手动加锁
     */
    @Test
    public void testManualLock() throws InterruptedException {
//        IntStream.range(0, 10000).forEach(i -> executorService.execute(this::manualBuy));
        IntStream.range(0, 1000).forEach(i -> executorService.execute(this::manualBuy));
        TimeUnit.MINUTES.sleep(1);
        log.error("count值为{}", count);
    }

    /**
     * 当此注解被应用到一个方法上时，
     * AOP（面向切面编程）机制会在执行该方法前尝试获取 ZooKeeper 上对应的分布式锁，并在方法执行完成后释放该锁
     * */
    @ZooLock(key = "buy", timeout = 1, timeUnit = TimeUnit.MINUTES)
    public void aopBuy(int userId) {
//        log.info("{} 正在出库。。。", userId);
        doBuy();
//        log.info("{} 扣库存成功。。。", userId);
    }

    public void manualBuy() {
        String lockPath = "/buy";
//        log.info("try to buy sth.");
        try {
            InterProcessMutex lock = new InterProcessMutex(zkClient, lockPath); // 手动加锁，其实使用Redission的效果感觉也可以
            try {
                if (lock.acquire(1, TimeUnit.MINUTES)) {
                    doBuy();
//                    log.info("buy successfully!");
                }
            } finally {
                lock.release(); // 释放锁
            }
        } catch (Exception e) {
            log.error("zk error");
        }
    }

    public void doBuy() {
        count--;
        log.info("count值为{}", count);
    }

}

