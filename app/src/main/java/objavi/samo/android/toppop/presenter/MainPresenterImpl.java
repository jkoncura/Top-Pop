package objavi.samo.android.toppop.presenter;

import java.util.ArrayList;

import objavi.samo.android.toppop.MainContract;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.Album;

public class MainPresenterImpl implements MainContract.MainPresenter,
                        MainContract.Interactor.OnFinishedListener {

    private MainContract.MainView mMainView;
    private MainContract.Interactor mInteractor;

    public MainPresenterImpl(MainContract.MainView mainView,
                             MainContract.Interactor interactor){
        this.mMainView = mainView;
        this.mInteractor = interactor;
    }

    @Override
    public void requestDataFromServer() {
        mInteractor.getFeedArrayList(this);

    }
    @Override
    public void onPullRefresh() {
        mInteractor.getFeedArrayList(this);
    }

    @Override
    public void onSortNormal(String normal) {
        mMainView.sortRecyclerView(normal);
    }

    @Override
    public void onSortAscending(String ascending) {
        mMainView.sortRecyclerView(ascending);
    }

    @Override
    public void onSortDescending(String descending) {
        mMainView.sortRecyclerView(descending);
    }

    @Override
    public void onFinished(ArrayList<Feed> feedArrayList) {
        mMainView.populateRecyclerView(feedArrayList);
        mMainView.onRefreshingEnded();
    }

    @Override
    public void onFailure(Throwable t) {
        mMainView.onResponseFailure(t);
        mMainView.onRefreshingEnded();
    }
}
