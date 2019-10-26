package self.liang.event.center.impl;

import self.liang.event.center.IEvent;
import self.liang.event.center.IEventHandler;

import java.util.concurrent.CountDownLatch;

public class TestEventHandler implements IEventHandler<String> {

    CountDownLatch countDownLatch;

    private int count = 0;

    @Override
    public void onEventReceiver(IEvent<String> event) {
//        synchronized (this) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
//        }
        if(countDownLatch != null){
            countDownLatch.countDown();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
