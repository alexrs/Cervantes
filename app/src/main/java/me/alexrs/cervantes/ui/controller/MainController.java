package me.alexrs.cervantes.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.alexrs.cervantes.ui.adapter.MainPagerAdapter;
import me.alexrs.cervantes.ui.presenter.MainPresenter;

/**
 * @author Alejandro on 09/09/14.
 */
public class MainController implements Controller {

    MainPresenter presenter;

    public MainController(MainPresenter presenter) {
        this.presenter = presenter;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, int id) {
        View rootView = inflater.inflate(id, container, false);
        presenter.onCreateView(rootView);
        return rootView;
    }

    public void setAdapter(MainPagerAdapter adapter) {
        presenter.setAdapter(adapter);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStop() {
    }
}
