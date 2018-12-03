package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("title")
    private String trackTitle;

    @SerializedName("duration")
    private int trackDuration;

    @SerializedName("position")
    private int trackPosition;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("album")
    private Album album;

    public String getTrackTitle() {
        return trackTitle;
    }

    public int getTrackDuration() {
        return trackDuration;
    }


    public int getTrackPosition() {
        return trackPosition;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }


}
