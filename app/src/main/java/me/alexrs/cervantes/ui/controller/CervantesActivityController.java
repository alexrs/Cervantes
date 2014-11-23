package me.alexrs.cervantes.ui.controller;

import android.app.FragmentManager;
import android.os.Bundle;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.fragment.CervantesFragment;
import me.alexrs.cervantes.ui.presenter.CervantesActivityPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesActivityController extends ActivityController {

  @Inject CervantesActivityPresenter presenter;
  private FragmentManager fragmentManager;

  public CervantesActivityController(CervantesActivityPresenter presenter) {
    this.presenter = presenter;
  }

  public void setFragmentManager(FragmentManager fragmentManager) {
    this.fragmentManager = fragmentManager;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    fragmentManager.beginTransaction().replace(R.id.container, new CervantesFragment()).commit();
  }
}
