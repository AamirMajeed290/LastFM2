package example.code.lastfm.model;

import com.google.gson.annotations.SerializedName;

public class Model {
    private Results results;

    @SerializedName("results")
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
