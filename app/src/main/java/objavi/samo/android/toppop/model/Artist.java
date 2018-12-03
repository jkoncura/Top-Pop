package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("name")
    private String artistName;

    public String getArtistName() {
        return artistName;
    }


}
