package objavi.samo.android.toppop.presenter;

import java.util.ArrayList;

import objavi.samo.android.toppop.MainContract;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.Album;

public class AlbumPresenterImpl implements MainContract.AlbumPresenter,
        MainContract.Interactor.OnCompletedListener {

    private MainContract.AlbumView mAlbumView;
    private MainContract.Interactor mInteractor;

    public AlbumPresenterImpl(MainContract.AlbumView albumView,
                              MainContract.Interactor interactor) {
        this.mAlbumView = albumView;
        this.mInteractor = interactor;
    }

    @Override
    public void requestDataFromServer(int albumId) {
        mInteractor.getAlbumData(albumId, this);
    }


    @Override
    public void onCompleted(Album album) {
        mAlbumView.populateView(album);
    }

    @Override
    public void onFailure(Throwable t) {


    }
}




