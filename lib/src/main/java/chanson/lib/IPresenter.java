package chanson.lib;

import android.content.Context;
import android.view.View;

/**
 * Created by Chanson on 2016/5/19.
 */
public interface IPresenter<T,R> extends VPBus.VPBusSubscription<R>{
    public void bindView(View v);
    public int getLayoutId();
    public Context getContext();
}
