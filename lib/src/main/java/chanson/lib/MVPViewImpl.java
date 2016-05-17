package chanson.lib;

import android.view.LayoutInflater;
import android.view.View;

import java.util.HashMap;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Chanson on 2016/5/12.
 */
public abstract class MVPViewImpl<T> implements IMVPView<T> {
    protected IMVPPresenter<T> presenter;
    private Observable<View> observable;
    protected View view;

    public void initView(IMVPPresenter<T> presenter){
        initView(presenter,null);
    }

    public void initView(IMVPPresenter<T> presenter, final MVPViewInitListener<T> listener){
        this.presenter = presenter;
        observable.create(new Observable.OnSubscribe<View>() {
            @Override
            public void call(Subscriber<? super View> subscriber) {
                View v = LayoutInflater.from(MVPViewImpl.this.presenter.getContext()).inflate(MVPViewImpl.this.presenter.getLayoutId(),null);
                subscriber.onNext(v);
                subscriber.onCompleted();
            }
        }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<View>() {
            @Override
            public void call(View view) {
                MVPViewImpl.this.view = view;
                if(listener == null) {
                    MVPViewImpl.this.presenter.attachView(MVPViewImpl.this);
                }else{
                    listener.onInitComplete(MVPViewImpl.this);
                }
            }
        });
    }

    public View getView(){
        return view;
    }

}
