package objavi.samo.android.toppop.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import objavi.samo.android.toppop.MainContract;
import objavi.samo.android.toppop.R;
import objavi.samo.android.toppop.interactor.InteractorImpl;
import objavi.samo.android.toppop.model.Track;
import objavi.samo.android.toppop.model.Album;
import objavi.samo.android.toppop.presenter.AlbumPresenterImpl;

public class AlbumActivity extends AppCompatActivity implements MainContract.AlbumView {
    private static final String TAG = "AlbumActivity";

    private static final String EXTRA_TRACK_NAME =
            "objavi.samo.android.toppop.view.track_name";
    private static final String EXTRA_ARTIST_NAME =
            "objavi.samo.android.toppop.view.artist_name";
    private static final String EXTRA_ALBUM_NAME =
            "objavi.samo.android.toppop.view.album_name";
    private static final String EXTRA_ALBUM_ID =
            "objavi.samo.android.toppop.view.album_id";
    private static final String EXTRA_ALBUM_COVER =
            "objavi.samo.android.toppop.view.album_cover";

    private ImageView albumCover;
    private TextView trackName, artistName, albumName, albumPlaylist;

    private Context mContext = AlbumActivity.this;

    private MainContract.AlbumPresenter mPresenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        System.out.println(TAG + " onCreate started");

        albumCover = findViewById(R.id.iv_cover_photo);
        trackName = findViewById(R.id.tv_track_name);
        artistName = findViewById(R.id.tv_artist_name);
        albumName = findViewById(R.id.tv_album_name);
        albumPlaylist = findViewById(R.id.tv_album_playlist);

        mPresenter = new AlbumPresenterImpl(this, new InteractorImpl());

        Intent intent = getIntent();

        mPresenter.requestDataFromServer(intent.getIntExtra(EXTRA_ALBUM_ID, 0));

        trackName.setText(intent.getStringExtra(EXTRA_TRACK_NAME));
        artistName.setText(intent.getStringExtra(EXTRA_ARTIST_NAME));
        albumName.setText(intent.getStringExtra(EXTRA_ALBUM_NAME));
        Picasso.with(mContext)
                .load(intent.getStringExtra(EXTRA_ALBUM_COVER))
                .into(albumCover);

    }

    public static Intent newIntent (Context context,
                                    String trackName,
                                    String artistName,
                                    String albumName,
                                    int albumId,
                                    String albumCover){
        Intent intent = new Intent(context, AlbumActivity.class);
        intent.putExtra(EXTRA_TRACK_NAME, trackName);
        intent.putExtra(EXTRA_ARTIST_NAME, artistName);
        intent.putExtra(EXTRA_ALBUM_NAME, albumName);
        intent.putExtra(EXTRA_ALBUM_ID, albumId);
        intent.putExtra(EXTRA_ALBUM_COVER, albumCover);
        return intent;
    }

    @Override
    public void populateView (Album album) {
        ArrayList<Track> albumTracks = album.getAlbumTracks().getAlbumTracks();
        StringBuilder playlist = new StringBuilder();
        for(int i=1; i <= albumTracks.size(); i++){
            playlist.append(i);
            playlist.append(". ");
            playlist.append(albumTracks.get(i-1).getTrackTitle());
            playlist.append(System.lineSeparator());
        }
        albumPlaylist.setText(playlist);
    }

    @Override
    public void onResponseFailure(Throwable t) {
        Toast.makeText(mContext,
                "Couldn't fetch data from the server: " + t.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
