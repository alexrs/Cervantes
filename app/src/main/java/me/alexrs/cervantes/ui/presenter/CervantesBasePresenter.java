package me.alexrs.cervantes.ui.presenter;

import android.content.Context;
import android.view.View;
import butterknife.ButterKnife;
import javax.inject.Inject;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class CervantesBasePresenter implements AbsPresenter {

  @Inject public Context context;

  @Override
  public void onCreateView(View view) {
    ButterKnife.inject(this, view);
    onViewCreated();
    hookUpListeners();
  }
}
