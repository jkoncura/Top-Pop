package objavi.samo.android.toppop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import objavi.samo.android.toppop.R;
import objavi.samo.android.toppop.model.Feed;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {


    private ArrayList<Feed> mFeed;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {

        void onItemClick (String trackName,
                          String artistName,
                          String albumName,
                          int albumId,
                          String albumCover);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }

    public SongAdapter (Context context, ArrayList<Feed> feed){
        this.mContext = context;
        this.mFeed = feed;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.item_track, parent,false);
        return new ViewHolder(songView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Feed feed = mFeed.get(position);

        String trackRanking = String.valueOf(feed.getTrackRanking());
        final String trackName = feed.getTrackName();
        final String artistName = feed.getArtistName();
        int trackDuration = feed.getTrackDuration();
        String trackDurationFormatted = String.format("%02d:%02d",
                                                trackDuration / 60,
                                                trackDuration % 60 );

        viewHolder.trackRanking.setText(trackRanking);
        viewHolder.trackName.setText(trackName);
        viewHolder.artistName.setText(artistName);
        viewHolder.trackDuration.setText(trackDurationFormatted);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(trackName,
                                                artistName,
                                                feed.getAlbumName(),
                                                feed.getAlbumId(),
                                                feed.getAlbumCover());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFeed.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView trackRanking, trackName, artistName, trackDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trackRanking = itemView.findViewById(R.id.tv_track_ranking);
            trackName = itemView.findViewById(R.id.tv_track_name);
            artistName = itemView.findViewById(R.id.tv_artist_name);
            trackDuration = itemView.findViewById(R.id.tv_track_duration);
        }
    }
    public void sortNormal(){
        Collections.sort(mFeed, Feed.COMPARE_BY_TRACK_RANKING);
        notifyDataSetChanged();
    }
    public void sortAscending(){
        Collections.sort(mFeed, Feed.COMPARE_BY_TRACK_DURATION_ASCENDING);
        notifyDataSetChanged();
    }
    public void sortDescending(){
        Collections.sort(mFeed, Feed.COMPARE_BY_TRACK_DURATION_DESCENDING);
        notifyDataSetChanged();
    }
}
