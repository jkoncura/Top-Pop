package objavi.samo.android.toppop;

import android.widget.Toast;

import java.util.ArrayList;

import objavi.samo.android.toppop.model.Data;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.Track;
import objavi.samo.android.toppop.model.children.Album;
import objavi.samo.android.toppop.network.DeezerApi;
import objavi.samo.android.toppop.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InteractorImpl implements MainContract.Interactor  {

    @Override
    public void getFeedArrayList(final OnFinishedListener onFinishedListener) {

        DeezerApi deezerApi = RetrofitInstance
                .getRetrofitInstance()
                .create(DeezerApi.class);

        Call<Data> call = deezerApi.getTrackList();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                ArrayList<Feed> feedArrayList = new ArrayList<>();

                ArrayList<Track> trackList = response.body().getTrackList();

                for (int i = 0; i <trackList.size(); i++){
                    Track track = trackList.get(i);
                    int trackRanking = i+1;
                    String trackName = track.getTrackTitle();
                    String artistName = track
                            .getArtist()
                            .getArtistName();
                    int trackDuration = track.getTrackDuration();

                    feedArrayList.add(new Feed(trackRanking,
                            trackName,
                            artistName,
                            trackDuration));
                }
                onFinishedListener.onFinished(feedArrayList);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

    @Override
    public void getAlbumData(OnFinishedListener onFinishedListener) {
        DeezerApi deezerApi = RetrofitInstance
                .getRetrofitInstance()
                .create(DeezerApi.class);

        Call<Album> call = deezerApi.getAlbumData(2);
    }
}
