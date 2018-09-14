package example.code.lastfm.albumDetail;

import example.code.lastfm.BasePresenter;
import example.code.lastfm.BaseView;

public interface AlbumDetailContract {

    interface Presenter extends BasePresenter {
        void setAlbum(String image, String name, String artist);
    }

    interface View extends BaseView<Presenter> {
        void setAlbum(String image, String name, String artist);
    }
}
