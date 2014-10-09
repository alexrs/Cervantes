package me.alexrs.cervantes.ui.presenter;

import android.view.View;

import butterknife.ButterKnife;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class CervantesPresenter implements Presenter {

    @Override
    public void onCreateView(View view) {
        ButterKnife.inject(this, view);
        hookUpListeners();
    }
}
