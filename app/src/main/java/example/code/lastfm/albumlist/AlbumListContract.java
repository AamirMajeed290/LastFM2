package example.code.lastfm.albumlist;

import android.support.annotation.NonNull;

import java.util.List;

import example.code.lastfm.BasePresenter;
import example.code.lastfm.BaseView;
import example.code.lastfm.model.Album;

public interface AlbumListContract {

    interface Presenter extends BasePresenter{
        void loadAlbums(@NonNull String albumsToLoad);
    }

    interface View extends BaseView<Presenter> {
        void displayAlbums(@NonNull List<Album> albums);
        void displayError(@NonNull String error);
    }
}
