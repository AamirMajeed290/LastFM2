package example.code.lastfm.albumlist;

import android.support.annotation.NonNull;

import java.util.List;

import example.code.lastfm.model.Album;
import example.code.lastfm.model.AlbumCallback;
import example.code.lastfm.model.LastFMApiImpl;

public class AlbumListPresenter implements  AlbumListContract.Presenter, OnAlbumLoadedListener{

    private AlbumListContract.View view;

    public AlbumListPresenter(@NonNull AlbumListContract.View view){
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadAlbums(@NonNull String albumsToLoad) {
        new AlbumCallback().getAlbum(LastFMApiImpl.getLastFMApi(), albumsToLoad , this);
    }

    @Override
    public void onAlbumLoaded(List<Album> albumList) {
        view.displayAlbums(albumList);
    }

    @Override
    public void onAlbumError(String error) {
        view.displayError(error);
    }

}
