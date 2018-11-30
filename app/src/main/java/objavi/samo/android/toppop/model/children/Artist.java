package objavi.samo.android.toppop.model.children;

import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("name")
    private String artistName;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                '}';
    }
}
