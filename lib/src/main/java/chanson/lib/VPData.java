package chanson.lib;

import chanson.lib.view.IView;

/**
 * Created by Chanson on 2016/5/25.
 */
public abstract class VPData {

    private IView<VPData> view;

    public void notifyViewChange(){
        view.refresh(this);
    }

}
