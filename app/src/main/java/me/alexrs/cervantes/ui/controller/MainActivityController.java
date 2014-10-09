package me.alexrs.cervantes.ui.controller;

import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.fragment.MainFragment;
import me.alexrs.cervantes.ui.presenter.MainActivityPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class MainActivityController implements Controller {

    MainActivityPresenter presenter;
    FragmentManager fragmentManager;

    public MainActivityController(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, int id) {
        return null;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onCreate() {
        fragmentManager.beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }

    @Override
    public void onStop() {

    }
}
