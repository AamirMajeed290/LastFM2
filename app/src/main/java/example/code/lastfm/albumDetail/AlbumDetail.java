package example.code.lastfm.albumDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.code.lastfm.R;

public class AlbumDetail extends AppCompatActivity {

    AlbumDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        String image = getIntent().getStringExtra("albumImage");
        String name = getIntent().getStringExtra("name");
        String artist = getIntent().getStringExtra("artist");
        AlbumDetailFragment albumDetailFragment = (AlbumDetailFragment) getSupportFragmentManager().findFragmentById(R.id.album_detail_fragment);

        assert albumDetailFragment != null;
        presenter = new AlbumDetailPresenter(albumDetailFragment);
        presenter.setAlbum(image, name, artist);
    }
}
