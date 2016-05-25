package chanson.lib.view;

import android.content.Context;
import android.view.View;

import chanson.lib.VPBus;

/**
 * Created by Chanson on 2016/5/19.
 */
public interface IView<T> extends VPBus.VPBusSubscription<T> {
    public void initView(Context context,int res);
    public View getView();
    public void refresh(T data);
}
