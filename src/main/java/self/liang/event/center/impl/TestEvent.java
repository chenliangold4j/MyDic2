package self.liang.event.center.impl;

import self.liang.event.center.IEvent;

public class TestEvent implements IEvent<String> {

    private int key;
    private String message;

    public TestEvent(int key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestEvent{" +
                "key=" + key +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int getEventKey() {
        return key;
    }

    @Override
    public String getEventMessage() {
        return message;
    }
}
