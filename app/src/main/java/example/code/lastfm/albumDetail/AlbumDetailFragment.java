package example.code.lastfm.albumDetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import example.code.lastfm.R;

public class AlbumDetailFragment extends Fragment implements AlbumDetailContract.View {

    AlbumDetailContract.Presenter presenter;

    public ImageView image;
    public TextView name;
    public TextView artist;

    public AlbumDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album_detail, container, false);
        image = view.findViewById(R.id.detail_image);
        name = view.findViewById(R.id.detail_name);
        artist = view.findViewById(R.id.detail_artist);
        return view;
    }

    @Override
    public void setPresenter(AlbumDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setAlbum(String imageUrl, String nameString, String artistString) {
        Picasso.get().load(imageUrl).into(image);
        name.setText(nameString);
        artist.setText(artistString);
    }
}
