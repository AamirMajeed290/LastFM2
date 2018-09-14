package example.code.lastfm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import example.code.lastfm.albumlist.AlbumListContract;
import example.code.lastfm.albumlist.AlbumListPresenter;
import example.code.lastfm.model.AlbumCallback;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class AlbumListUnitTest {

    private AlbumListPresenter presenter;

    @Mock
    private AlbumListContract.View view;

    @Mock
    private AlbumCallback albumCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPresenter_setsThePresenterToView() {
        presenter = new AlbumListPresenter(view);

        verify(view).setPresenter(presenter);
    }

}