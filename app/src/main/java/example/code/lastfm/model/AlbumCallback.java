package example.code.lastfm.model;

import android.support.annotation.NonNull;
import android.util.Log;

import example.code.lastfm.albumlist.OnAlbumLoadedListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumCallback implements Callback<Model> {

    private OnAlbumLoadedListener onAlbumLoadedListener;

    public AlbumCallback() {
    }

    @Override
    public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
        if( response.isSuccessful() ) {
            Model model = response.body();
            if(model != null && model.getResults() != null &&
                    model.getResults().getAlbummatches() != null &&
                    model.getResults().getAlbummatches().getAlbum() != null ) {
                if(model.getResults().getAlbummatches().getAlbum().size() != 0) {
                    onAlbumLoadedListener.onAlbumLoaded(model.getResults().getAlbummatches().getAlbum());
                } else {
                    onAlbumLoadedListener.onAlbumError("There is no results available for this search");
                }
            } else {
                onAlbumLoadedListener.onAlbumError("There was an error with your search");
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<Model> call, @NonNull Throwable t) {
        Log.e("Call error:", t.getMessage());
    }

    public void getAlbum(LastFMApi lastFMApi, String album, OnAlbumLoadedListener onAlbumLoadedListener) {
        this.onAlbumLoadedListener = onAlbumLoadedListener;
        final String method = "album.search";
        final String apiKey = "06bcf45620e992c76e5c35d87b5e7260";
        final String format = "json";
        Call<Model> resultsCall = lastFMApi.findAlbum(method, album, apiKey, format);
        resultsCall.enqueue(this);
    }

}
