package chanson.lib;

/**
 * Created by Chanson on 2016/5/19.
 */
public class VPBus {

    public void register(){}

    public void unregister(){}

    public interface VPBusSubscription<T>{
        public void notify(T data);
    }
}
