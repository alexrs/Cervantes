package me.alexrs.cervantes.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Alejandro Rodriguez
 */
public class FavsController implements Controller {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, int id) {
        View rootView = inflater.inflate(id, container, false);
        return rootView;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStop() {

    }
}
