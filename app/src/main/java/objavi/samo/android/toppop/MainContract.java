package objavi.samo.android.toppop;

import java.util.ArrayList;

import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.children.Album;

public interface MainContract {

    /**
     * Call when user interacts with the view and when the view is destroyed
     */

    interface MainPresenter {

        void requestDataFromServer();

        void onPullRefresh();

        void onSortNormal(String normal);

        void onSortAscending(String ascending);

        void onSortDescending(String descending);
    }

    interface AlbumPresenter {

        void requestDataFromServer();


    }

    interface MainView {

        void populateRecyclerView(ArrayList<Feed> feedArrayList);

        void sortRecyclerView(String sortingMethod);

        void onResponseFailure(Throwable throwable);

        void onRefreshingEnded();
    }

    interface AlbumView {

        void populateView();

        void onResponseFailure();
    }
    /**
     * To fetch the data from web service
     */
    interface Interactor {

        interface OnFinishedListener {
            void onFinished (ArrayList<Feed> feedArrayList);
            void onFinished (Album album);
            void onFailure(Throwable t);
        }

        void getFeedArrayList(OnFinishedListener onFinishedListener);

        void getAlbumData(OnFinishedListener onFinishedListener);
    }
}
