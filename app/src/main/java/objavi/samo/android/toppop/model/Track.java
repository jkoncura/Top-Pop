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

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
    }

    public int getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(int trackPosition) {
        this.trackPosition = trackPosition;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
