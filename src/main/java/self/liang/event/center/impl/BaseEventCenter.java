package self.liang.event.center.impl;

import self.liang.event.center.IEvent;
import self.liang.event.center.IEventCenter;
import self.liang.event.center.IEventHandler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class BaseEventCenter implements IEventCenter {

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final ReentrantLock reentrantLock = new ReentrantLock();

    ConcurrentHashMap<Integer, ConcurrentLinkedDeque<IEventHandler>> center = new ConcurrentHashMap<>();

    @Override
    public boolean registerListener(Integer key, IEventHandler eventHandler) {
        reentrantLock.lock();
        try {
            ConcurrentLinkedDeque<IEventHandler> theEventList = center.get(key);
            if (theEventList != null) {
                theEventList.add(eventHandler);
            } else {
                theEventList = new ConcurrentLinkedDeque<>();
                theEventList.add(eventHandler);
                center.put(key, theEventList);
            }
        } finally {
            reentrantLock.unlock();
        }
        return true;
    }

    @Override
    public boolean publishEvent(Integer key, IEvent event) {
        ConcurrentLinkedDeque<IEventHandler> theEventList = center.get(key);
        executorService.execute(() -> {
            for (IEventHandler eventHandler : theEventList) {
                eventHandler.onEventReceiver(event);
            }
        });
        return true;
    }

    @Override
    public boolean unregisterListener(Integer key, IEventHandler eventHandler) {
        reentrantLock.lock();
        try {
            ConcurrentLinkedDeque<IEventHandler> theEventList = center.get(key);
            if (theEventList != null) {
                theEventList.remove(eventHandler);
            }
        } finally {
            reentrantLock.unlock();
        }
        return true;
    }

}
