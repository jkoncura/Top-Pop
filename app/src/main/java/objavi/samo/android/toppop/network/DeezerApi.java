package objavi.samo.android.toppop.network;

import objavi.samo.android.toppop.model.Data;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.model.children.Album;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeezerApi {

    @GET("/chart/0/tracks/") // to ide endpoint
    Call<Data> getTrackList();

    @GET("/album/{id}")
    Call<Album> getAlbumData(@Path("id") int albumId);
}
