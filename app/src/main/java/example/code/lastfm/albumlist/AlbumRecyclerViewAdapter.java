package example.code.lastfm.albumlist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import example.code.lastfm.R;
import example.code.lastfm.albumDetail.AlbumDetail;
import example.code.lastfm.model.Album;

import java.util.List;


public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.AlbumViewHolder> {

    private List<Album> albums;

    AlbumRecyclerViewAdapter(List<Album> items) {
        albums = items;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_item_row, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AlbumViewHolder holder, int position) {
        Album currentAlbum = albums.get(position);
        String url = "";
        if(currentAlbum != null) {
            if( currentAlbum.getImage() != null && currentAlbum.getImage().get(0) != null) {
                url = currentAlbum.getImage().get(0).getText();
            }
            if(!url.isEmpty()) {
                Picasso.get().load(url).into(holder.image);
            }
            holder.name.setText(currentAlbum.getName());
            holder.artist.setText(currentAlbum.getArtist());
        }
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image;
        public final TextView name;
        public final TextView artist;

        AlbumViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
            artist = view.findViewById(R.id.artist);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), AlbumDetail.class);
                    intent.putExtra("albumImage", albums.get(getAdapterPosition()).getImage().get(0).getText());
                    intent.putExtra("name", albums.get(getAdapterPosition()).getName());
                    intent.putExtra("artist", albums.get(getAdapterPosition()).getArtist());
                    view.getContext().startActivity(intent);
                }
            });
        }

    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
