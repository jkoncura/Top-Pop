package objavi.samo.android.toppop.network;

import objavi.samo.android.toppop.model.Data;
import objavi.samo.android.toppop.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeezerApi {

    @GET("/chart/0/tracks/")
    Call<Data> getTrackList();

    @GET("/album/{id}/")
    Call<Album> getAlbumData(@Path("id") int albumId);
}
