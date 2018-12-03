package objavi.samo.android.toppop;

import java.util.ArrayList;

import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.Album;

public interface MainContract {

    interface MainPresenter {

        void requestDataFromServer();

        void onPullRefresh();

        void onSortNormal(String normal);

        void onSortAscending(String ascending);

        void onSortDescending(String descending);
    }

    interface AlbumPresenter {

        void requestDataFromServer(int albumId);
    }

    interface MainView {

        void populateRecyclerView(ArrayList<Feed> feedArrayList);

        void sortRecyclerView(String sortingMethod);

        void onResponseFailure(Throwable throwable);

        void onRefreshingEnded();
    }

    interface AlbumView {

        void populateView(Album album);

        void onResponseFailure(Throwable throwable);
    }

    interface Interactor {

        interface OnFinishedListener {
            void onFinished (ArrayList<Feed> feedArrayList);
            void onFailure(Throwable t);
        }
        interface OnCompletedListener {
            void onCompleted (Album album);
            void onFailure(Throwable t);
        }

        void getFeedArrayList(OnFinishedListener onFinishedListener);

        void getAlbumData(int albumId, OnCompletedListener onCompleteListener);
    }
}
