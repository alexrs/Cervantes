package me.alexrs.cervantes.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Alejandro Rodriguez <alexrs952gmail.com>
 */
public interface Controller {

    /**
     *
     * @param inflater
     * @param container
     * @param id
     * @return
     */
    View onCreateView(LayoutInflater inflater, ViewGroup container, int id);

    /**
     *
     */
    void onCreate();

    /**
     *
     */
    void onStop();

}
