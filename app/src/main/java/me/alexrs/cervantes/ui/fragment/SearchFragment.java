package me.alexrs.cervantes.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.controller.SearchController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class SearchFragment extends CervantesFragment {

    @Inject
    SearchController controller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return controller.onCreateView(inflater, container, R.layout.f_search);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller.onCreate();
        controller.setFragmentManager(getFragmentManager());
    }

    @Override
    public void onStop() {
        super.onStop();
        controller.onStop();
    }
}
