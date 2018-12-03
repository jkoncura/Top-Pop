package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import objavi.samo.android.toppop.model.Track;

public class AlbumTracks {

    @SerializedName("data")
    private ArrayList<Track> albumTracks;

    public ArrayList<Track> getAlbumTracks() {
        return albumTracks;
    }

}
