package me.alexrs.cervantes.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.adapter.MainPagerAdapter;
import me.alexrs.cervantes.ui.controller.MainActivityController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class MainActivity extends CervantesActivity {

    @Inject
    MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        controller.setFragmentManager(getFragmentManager());
        controller.onCreate();
    }

}
