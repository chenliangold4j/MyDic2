package self.liang.event.center;

public interface IEvent<T> {

    public int getEventKey();
    public T getEventMessage();

}
