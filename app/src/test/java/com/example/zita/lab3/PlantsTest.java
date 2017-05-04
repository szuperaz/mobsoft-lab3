package com.example.zita.lab3;

import com.example.zita.lab3.model.Plant;
import com.example.zita.lab3.ui.overview.OverviewPresenter;
import com.example.zita.lab3.ui.overview.OverviewScreen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static com.example.zita.lab3.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PlantsTest {
    private OverviewPresenter overviewPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        overviewPresenter = new OverviewPresenter();
    }

    @Test
    public void testGetPlants() {
        OverviewScreen overviewScreen = mock(OverviewScreen.class);
        overviewPresenter.attachScreen(overviewScreen);
        overviewPresenter.getPlants();

        ArgumentCaptor<ArrayList<Plant>> plantsCaptor = ArgumentCaptor.forClass((Class<ArrayList<Plant>>) (Class) ArrayList.class);
        verify(overviewScreen, times(1)).showPlants(plantsCaptor.capture());

        List<Plant> capturedPlants = plantsCaptor.getValue();
        assertEquals(Long.valueOf(1L), capturedPlants.get(0).getId());
        assertEquals(Long.valueOf(2L), capturedPlants.get(1).getId());
    }
}
