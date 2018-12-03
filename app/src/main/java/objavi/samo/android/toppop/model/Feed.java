package objavi.samo.android.toppop.model;

import java.util.Comparator;

public class Feed {

    private int trackRanking;
    private String trackName;
    private String artistName;
    private int trackDuration;
    private int albumId;
    private String albumCover;
    private String albumName;

    public Feed(int trackRanking,
                String trackName,
                String artistName,
                int trackDuration,
                int albumId,
                String albumCover,
                String albumName) {

        this.trackRanking = trackRanking;
        this.trackName = trackName;
        this.artistName = artistName;
        this.trackDuration = trackDuration;
        this.albumId  = albumId;
        this.albumCover = albumCover;
        this.albumName = albumName;
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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
