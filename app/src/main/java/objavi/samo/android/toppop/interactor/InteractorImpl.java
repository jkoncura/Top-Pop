package objavi.samo.android.toppop.interactor;

import java.util.ArrayList;

import objavi.samo.android.toppop.MainContract;
import objavi.samo.android.toppop.model.Data;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.Track;
import objavi.samo.android.toppop.model.Album;
import objavi.samo.android.toppop.network.DeezerApi;
import objavi.samo.android.toppop.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InteractorImpl implements MainContract.Interactor {

    /**
     * Responsible for getting data using the REST Api with retrofit library
     * and passing data through onFinishedListener and onCompletedListener callbacks
     */

    @Override
    public void getFeedArrayList(final OnFinishedListener onFinishedListener) {

        DeezerApi deezerApi = RetrofitInstance
                .getRetrofitInstance()
                .create(DeezerApi.class);

        Call<Data> call = deezerApi.getTrackList();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                ArrayList<Track> trackList = response.body().getTrackList();

                ArrayList<Feed> feedArrayList = new ArrayList<>();

                for (int i = 0; i <trackList.size(); i++){
                    Track track = trackList.get(i);
                    int trackRanking = track.getTrackPosition();
                    String trackName = track.getTrackTitle();
                    String artistName = track
                            .getArtist()
                            .getArtistName();
                    int trackDuration = track.getTrackDuration();
                    int albumId = track.getAlbum().getAlbumId();
                    String albumCover = track.getAlbum().getAlbumCover();
                    String albumName = track.getAlbum().getAlbumTitle();

                    feedArrayList.add(new Feed(trackRanking,
                            trackName,
                            artistName,
                            trackDuration,
                            albumId,
                            albumCover,
                            albumName));
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
    public void getAlbumData(int albumId, final OnCompletedListener onCompletedListener) {
        DeezerApi deezerApi = RetrofitInstance
                .getRetrofitInstance()
                .create(DeezerApi.class);

        Call<Album> call = deezerApi.getAlbumData(albumId);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Album album = response.body();
                onCompletedListener.onCompleted(album);
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                onCompletedListener.onFailure(t);
            }
        });
    }

}
