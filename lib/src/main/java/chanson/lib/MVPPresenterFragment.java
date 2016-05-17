package chanson.lib;

import android.app.Fragment;

/**
 * Created by Chanson on 2016/5/11.
 */
public abstract class MVPPresenterFragment<T> extends Fragment implements IMVPPresenter<T>{

    public void attachView(IMVPView<T> view){

    }
}
