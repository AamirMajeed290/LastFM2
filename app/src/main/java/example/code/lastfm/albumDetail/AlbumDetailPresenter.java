package example.code.lastfm.albumDetail;

import android.support.annotation.NonNull;

public class AlbumDetailPresenter implements AlbumDetailContract.Presenter {

    private AlbumDetailContract.View view;

    AlbumDetailPresenter(@NonNull AlbumDetailContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void setAlbum(String image, String name, String artist) {
        view.setAlbum(image, name, artist);
    }

}
