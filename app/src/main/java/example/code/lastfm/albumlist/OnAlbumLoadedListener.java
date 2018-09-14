package example.code.lastfm.albumlist;

import java.util.List;

import example.code.lastfm.model.Album;

public interface OnAlbumLoadedListener {

    void onAlbumLoaded(List<Album> albumList);

    void onAlbumError(String error);
}
