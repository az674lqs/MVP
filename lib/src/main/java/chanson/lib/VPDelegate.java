package chanson.lib;

import android.view.View;

import java.util.HashMap;

import chanson.lib.presenter.IPresenter;
import chanson.lib.view.IView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Chanson on 2016/5/19.
 */
public class VPDelegate {
    private HashMap<IPresenter,IView> VPMap = new HashMap<>();

    public void append(IPresenter p){
        ViewClass viewClass = p.getClass().getAnnotation(ViewClass.class);
        ViewData viewDataClass = p.getClass().getAnnotation(ViewData.class);
        if(viewClass == null || viewDataClass == null){
            throw new RuntimeException("warning");
        }
        IView view = null;
        VPData data = null;
        try {
            view = viewClass.value().newInstance();
            data = viewDataClass.value().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        VPMap.put(p,view);
        bindVP(view,p);
    }

    private void bindVP(final IView v,final IPresenter p){
        Observable.create(new Observable.OnSubscribe<View>() {
            @Override
            public void call(Subscriber<? super View> subscriber) {
                // TODO: 2016/5/19 有可能到这步的时候p或者v已经被销毁
                v.initView(p.getContext(), p.getLayoutId());
                subscriber.onNext(v.getView());
                subscriber.onCompleted();
            }
        }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<View>() {
            @Override
            public void call(View view) {
                // TODO: 2016/5/19 有可能到这步的时候p已经被销毁
                p.bindView(view);
            }
        });
    }

    public void subtract(IPresenter p){
        IView view = VPMap.get(p);
        if(view != null){
            VPMap.remove(view.getClass());
        }
    }

}
