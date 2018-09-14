package example.code.lastfm.albumlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.code.lastfm.R;

public class AlbumListActivity extends AppCompatActivity {

    AlbumListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        AlbumListFragment fragment = (AlbumListFragment) getSupportFragmentManager().findFragmentById(R.id.album_list_fragment);

        assert fragment != null;
        presenter = new AlbumListPresenter(fragment);
    }

}
