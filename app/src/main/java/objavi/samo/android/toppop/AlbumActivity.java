package objavi.samo.android.toppop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import objavi.samo.android.toppop.model.Feed;

public class AlbumActivity extends AppCompatActivity{
    private static final String TAG = "AlbumActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        System.out.println(TAG + " onCreate started");
    }

    public static Intent newIntent (Context context){
        Intent intent = new Intent(context, AlbumActivity.class);
        return intent;
    }

}
