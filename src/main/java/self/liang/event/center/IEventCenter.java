package self.liang.event.center;

public interface IEventCenter {

    public boolean registerListener(Integer key,IEventHandler eventHandler);

    public boolean publishEvent(IEvent event);

    public boolean unregisterListener(Integer key,IEventHandler eventHandler);

    public boolean shutdown();
}
