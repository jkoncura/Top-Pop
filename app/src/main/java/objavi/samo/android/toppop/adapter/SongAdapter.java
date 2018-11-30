package objavi.samo.android.toppop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import objavi.samo.android.toppop.AlbumActivity;
import objavi.samo.android.toppop.R;
import objavi.samo.android.toppop.model.Feed;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {


    private ArrayList<Feed> mTracks;
    private RecyclerItemClickListener mRecyclerItemClickListener;
    private Context mContext;

    public interface RecyclerItemClickListener {

        void onItemClick (Feed feed);
    }

    public SongAdapter (Context context, ArrayList<Feed> tracks, RecyclerItemClickListener listener){
        this.mContext = context;
        this.mTracks = tracks;
        this.mRecyclerItemClickListener = listener;

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
        final Feed feed = mTracks.get(position);

        viewHolder.songRanking.setText(String.valueOf(feed.getTrackRanking()));
        viewHolder.songName.setText(feed.getTrackName());
        viewHolder.artistName.setText(feed.getArtistName());
        viewHolder.songDuration.setText(String.valueOf(feed.getTrackDuration()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AlbumActivity.newIntent(mContext);
                mContext.startActivity(intent);
                mRecyclerItemClickListener.onItemClick(feed);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView songRanking, songName, artistName, songDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songRanking = itemView.findViewById(R.id.tv_track_ranking);
            songName = itemView.findViewById(R.id.tv_track_name);
            artistName = itemView.findViewById(R.id.tv_artist_name);
            songDuration = itemView.findViewById(R.id.tv_track_duration);
        }
    }
    public void clear(){
        mTracks.clear();
        notifyDataSetChanged();
    }
    public void addAll(ArrayList<Feed> list){
        mTracks.addAll(list);
        notifyDataSetChanged();
    }

    public void sortNormal(){
        Collections.sort(mTracks, Feed.COMPARE_BY_TRACK_RANKING);
        notifyDataSetChanged();
    }
    public void sortAscending(){
        Collections.sort(mTracks, Feed.COMPARE_BY_TRACK_DURATION_ASCENDING);
        notifyDataSetChanged();
    }
    public void sortDescending(){
        Collections.sort(mTracks, Feed.COMPARE_BY_TRACK_DURATION_DESCENDING);
        notifyDataSetChanged();
    }
}
