package me.alexrs.cervantes.ui.fragment;

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
}
