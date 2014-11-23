package me.alexrs.cervantes.ui.fragment;

import android.os.Bundle;
import android.view.View;
import javax.inject.Inject;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.ui.controller.CervantesFragmentController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesFragment extends BaseFragment {

  @Inject CervantesFragmentController controller;

  @Override public void initializeController() {
    ((CervantesApplication) getActivity().getApplication()).inject(this);
    setController(controller);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    controller.onViewCreated(view, savedInstanceState);
  }
}
