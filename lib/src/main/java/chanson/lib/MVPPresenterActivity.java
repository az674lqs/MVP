package chanson.lib;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Chanson on 2016/5/11.
 */
public abstract class MVPPresenterActivity<T> extends Activity implements IMVPPresenter<T> {

    protected IMVPView<T> view;

    @Override
    public void attachView(IMVPView<T> view) {
        this.view = view;
        setContentView(view.getView());
    }

    @Override
    public void detachView() {
        this.view.destroy();
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return this.view == null;
    }

    public Context getContext(){
        return this;
    }

}
