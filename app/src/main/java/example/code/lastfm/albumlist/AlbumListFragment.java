package example.code.lastfm.albumlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import example.code.lastfm.R;
import example.code.lastfm.model.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumListFragment extends Fragment implements AlbumListContract.View {

    private AlbumListContract.Presenter presenter;

    private AlbumRecyclerViewAdapter adapter;

    private EditText albumTitleArea;

    private ProgressBar progressBar;

    public AlbumListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_fragment, container, false);

        albumTitleArea = view.findViewById(R.id.title_search_bar);
        Button searchButton = view.findViewById(R.id.search_button);
        RecyclerView albumRecyclerView = view.findViewById(R.id.album_recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);

        List<Album> albums = new ArrayList<>();
        adapter = new AlbumRecyclerViewAdapter(albums);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        albumRecyclerView.setLayoutManager(layoutManager);
        albumRecyclerView.setItemAnimator(new DefaultItemAnimator());
        albumRecyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                presenter.loadAlbums(albumTitleArea.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void displayAlbums(@NonNull List<Album> albumList) {
        adapter.setAlbums(albumList);
        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayError(@NonNull String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(AlbumListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
