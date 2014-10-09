package me.alexrs.cervantes.ui.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;

import me.alexrs.cervantes.ui.fragment.FavsFragment;
import me.alexrs.cervantes.ui.fragment.HistoryFragment;
import me.alexrs.cervantes.ui.fragment.SearchFragment;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGES = 3;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new SearchFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new FavsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGES;
    }
}
