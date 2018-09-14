package example.code.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("opensearch:totalResults")
    private String opensearchTotalResults;

    @SerializedName("opensearch:startIndex")
    private String opensearchStartIndex;

    @SerializedName("opensearch:itemsPerPage")
    private String opensearchItemsPerPage;

    private AlbumMatches albummatches;

    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    public AlbumMatches getAlbummatches() {
        return albummatches;
    }

    public void setAlbummatches(AlbumMatches albumMatches) {
        this.albummatches = albumMatches;
    }

}
