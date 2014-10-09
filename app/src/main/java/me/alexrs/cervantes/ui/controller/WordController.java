package me.alexrs.cervantes.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.alexrs.cervantes.ui.presenter.WordPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class WordController implements Controller {

    WordPresenter presenter;

    public WordController(WordPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, int id) {
        View rootView = inflater.inflate(id, container, false);
        presenter.onCreateView(rootView);
        return rootView;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStop() {

    }
}
