package me.alexrs.cervantes.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.controller.FavsController;
import me.alexrs.cervantes.ui.controller.WordController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class FavsFragment extends CervantesFragment {

    @Inject
    FavsController controller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return controller.onCreateView(inflater, container, R.layout.p_word);
    }

}
