package objavi.samo.android.toppop.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class Data {

    @SerializedName("data")
    private ArrayList<Track> trackList;

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<Track> trackList) {
        this.trackList = trackList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "trackList=" + trackList +
                '}';
    }
}
