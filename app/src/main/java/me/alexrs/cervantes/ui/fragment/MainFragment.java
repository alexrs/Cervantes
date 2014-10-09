package me.alexrs.cervantes.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.adapter.MainPagerAdapter;
import me.alexrs.cervantes.ui.controller.MainController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class MainFragment extends CervantesFragment {

    @Inject
    MainController controller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        controller.setAdapter(new MainPagerAdapter(getFragmentManager()));
        return controller.onCreateView(inflater, container, R.layout.f_main);
    }
}
