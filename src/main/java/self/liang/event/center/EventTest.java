package self.liang.event.center;

import self.liang.event.center.impl.BaseEventCenter;
import self.liang.event.center.impl.TestEvent;
import self.liang.event.center.impl.TestEventHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EventTest {
    public static  IEventCenter eventCenter;

    public static int threadCount = 5000;
    public static void main(String[] args) throws InterruptedException {
        eventCenter = new BaseEventCenter();
        TestEventHandler handler1 = new TestEventHandler();
        TestEventHandler handler2 = new TestEventHandler();
        eventCenter.registerListener(1,handler1);
        eventCenter.registerListener(2,handler2);

        //控制进程并发数量
        final Semaphore semaphore = new Semaphore(100);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            semaphore.acquire(); // 获取一个许可
            eventCenter.publishEvent(threadNum%2+1,new TestEvent(threadNum,""+threadNum));
            semaphore.release(); // 释放一个许可
        }
        eventCenter.shutdown();
        Thread.sleep(3000);
        System.out.println(handler1.getCount());
        System.out.println(handler2.getCount());
    }


}
