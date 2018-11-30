package objavi.samo.android.toppop.model;

import java.util.Comparator;

public class Feed {

    private int trackRanking;
    private String trackName;
    private String artistName;
    private int trackDuration;

    public Feed(int trackRanking, String trackName, String artistName, int trackDuration) {
        this.trackRanking = trackRanking;
        this.trackName = trackName;
        this.artistName = artistName;
        this.trackDuration = trackDuration;
    }

    public int getTrackRanking() {
        return trackRanking;
    }

    public void setTrackRanking(int trackRanking) {
        this.trackRanking = trackRanking;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
    }

    public static Comparator<Feed> COMPARE_BY_TRACK_DURATION_ASCENDING = new Comparator<Feed>() {
        @Override
        public int compare(Feed feed, Feed other) {
            return other.trackDuration - feed.trackDuration;
        }
    };
    public static Comparator<Feed> COMPARE_BY_TRACK_DURATION_DESCENDING = new Comparator<Feed>() {
        @Override
        public int compare(Feed feed, Feed other) {
            return feed.trackDuration - other.trackDuration;
        }
    };
    public static Comparator<Feed> COMPARE_BY_TRACK_RANKING = new Comparator<Feed>() {
        @Override
        public int compare(Feed feed, Feed other) {
            return feed.trackRanking - other.trackRanking;
        }
    };

}
