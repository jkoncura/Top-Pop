package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;

import objavi.samo.android.toppop.model.children.Album;
import objavi.samo.android.toppop.model.children.Artist;

public class Track {

    @SerializedName("title")
    private String trackTitle;

    @SerializedName("duration")
    private int trackDuration;

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

    @Override
    public String toString() {
        return "Track{" +
                "trackTitle='" + trackTitle + '\'' +
                ", trackDuration=" + trackDuration +
                ", artist=" + artist +
                ", album=" + album +
                '}';
    }
}
