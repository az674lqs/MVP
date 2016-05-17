package chanson.lib;

import android.content.Context;
import android.view.View;

import java.util.HashMap;

/**
 * Created by Chanson on 2016/5/11.
 */
public interface IMVPView<T> {
    public void initView(IMVPPresenter<T> presenter);
    public void initView(IMVPPresenter<T> presenter,MVPViewInitListener<T> listener);
    public View getView();
    public void setData(T data);
    public void setData(HashMap data);
    public void setData(String key,Object value);
    public void refresh();
    public void destroy();
    public T getData();

    public interface MVPViewInitListener<R>{
        public void onInitComplete(IMVPView<R> mvpView);
    }
}
