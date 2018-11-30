package objavi.samo.android.toppop.model.children;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("id")
    private String albumId;

    @SerializedName("cover_xl")
    private String trackCover;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTrackCover() {
        return trackCover;
    }

    public void setTrackCover(String trackCover) {
        this.trackCover = trackCover;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", trackCover='" + trackCover + '\'' +
                '}';
    }
}
