package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("id")
    private int albumId;

    @SerializedName("title")
    private String albumTitle;

    @SerializedName("tracks")
    private AlbumTracks AlbumTracks;

    @SerializedName("cover_xl")
    private String albumCover;

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public AlbumTracks getAlbumTracks() {
        return AlbumTracks;
    }

}
