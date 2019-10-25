package self.liang.event.center;

public interface IEventHandler<T> {

    public void onEventReceiver(IEvent<T> event);

}
