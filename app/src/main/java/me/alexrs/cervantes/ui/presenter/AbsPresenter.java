package me.alexrs.cervantes.ui.presenter;

import android.view.View;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public interface AbsPresenter {

  /**
   *
   * @param view
   */
  void onCreateView(View view);

  /**
   *
   */
  void hookUpListeners();

  void onViewCreated();
}
