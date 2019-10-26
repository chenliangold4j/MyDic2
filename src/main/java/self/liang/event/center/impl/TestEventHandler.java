package self.liang.event.center.impl;

import self.liang.event.center.IEvent;
import self.liang.event.center.IEventHandler;

public class TestEventHandler implements IEventHandler<String> {


    private int  count = 0;

    @Override
    public void onEventReceiver(IEvent<String> event) {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
