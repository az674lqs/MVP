package chanson.lib;

import android.content.Context;

/**
 * Created by Chanson on 2016/5/11.
 */
public interface IMVPPresenter<T> {
    public void attachView(IMVPView<T> view);
    public void detachView();
    public boolean isViewAttached();
    public int getLayoutId();
    public Context getContext();
}
