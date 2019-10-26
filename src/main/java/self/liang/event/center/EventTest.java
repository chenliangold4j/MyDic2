package self.liang.event.center;

import self.liang.event.center.impl.BaseEventCenter;
import self.liang.event.center.impl.TestEvent;
import self.liang.event.center.impl.TestEventHandler;

import java.util.concurrent.CountDownLatch;
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
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        handler1.setCountDownLatch(countDownLatch);
        handler2.setCountDownLatch(countDownLatch);
        long time = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            eventCenter.publishEvent(new TestEvent(threadNum%2+1,""+threadNum));
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - time);
        eventCenter.shutdown();
        System.out.println(handler1.getCount());
        System.out.println(handler2.getCount());
    }


}
