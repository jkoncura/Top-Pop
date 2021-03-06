package objavi.samo.android.toppop.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import objavi.samo.android.toppop.MainContract;
import objavi.samo.android.toppop.R;
import objavi.samo.android.toppop.adapter.SongAdapter;
import objavi.samo.android.toppop.interactor.InteractorImpl;
import objavi.samo.android.toppop.model.Feed;
import objavi.samo.android.toppop.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, SongAdapter.OnItemClickListener{
    private static final String TAG = "MainActivity";

    private static String SORTING_NORMAL = "normal";
    private static String SORTING_ASCENDING = "ascending";
    private static String SORTING_DESCENDING = "descending";

    private SwipeRefreshLayout mSwipeContainer;
    private RecyclerView mRecyclerView;
    private SongAdapter mAdapter;

    private Context mContext = MainActivity.this;

    private MainContract.MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeContainer = findViewById(R.id.swipe_contanier);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMainPresenter = new MainPresenterImpl(this, new InteractorImpl());
        mMainPresenter.requestDataFromServer();

        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mMainPresenter.onPullRefresh();
            }
        });
    }


    @Override
    public void populateRecyclerView(ArrayList<Feed> feedArrayList) {
            mAdapter = new SongAdapter(mContext,feedArrayList);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public void sortRecyclerView(String sortingMethod) {
        if (sortingMethod.equals(SORTING_NORMAL)){
            mAdapter.sortNormal();
        }else if (sortingMethod.equals(SORTING_ASCENDING)){
            mAdapter.sortAscending();
        }else if(sortingMethod.equals(SORTING_DESCENDING)) {
            mAdapter.sortDescending();
        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(mContext,
                "Couldn't fetch data from the server: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onRefreshingEnded() {
        mSwipeContainer.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sorting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_normal){
            mMainPresenter.onSortNormal(SORTING_NORMAL);
        }
        if (id == R.id.action_sort_asc){
            mMainPresenter.onSortAscending(SORTING_ASCENDING);
        }
        if (id == R.id.action_sort_desc){
            mMainPresenter.onSortDescending(SORTING_DESCENDING);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(String trackName,
                            String artistName,
                            String albumName,
                            int albumId,
                            String albumCover) {

        Intent intent = AlbumActivity.newIntent(mContext,
                                                trackName,
                                                artistName,
                                                albumName,
                                                albumId,
                                                albumCover);
        startActivity(intent);
    }
}
