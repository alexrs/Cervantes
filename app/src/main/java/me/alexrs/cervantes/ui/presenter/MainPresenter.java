package me.alexrs.cervantes.ui.presenter;

import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.InjectView;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.adapter.MainPagerAdapter;

/**
 * @author Alejandro
 */
public class MainPresenter extends CervantesPresenter {


    @InjectView(R.id.main_pager)
    ViewPager viewPager;

    MainPagerAdapter adapter;

    @Override
    public void hookUpListeners() {
    }

    public void setAdapter(MainPagerAdapter adapter){
        this.adapter = adapter;
    }

    @Override
    public void onCreateView(View view) {
        super.onCreateView(view);
        viewPager.setAdapter(adapter);
    }
}
