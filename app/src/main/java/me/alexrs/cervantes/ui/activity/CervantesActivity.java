package me.alexrs.cervantes.ui.activity;

import android.os.Bundle;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.ui.controller.CervantesActivityController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesActivity extends BaseActivity {

  @Inject CervantesActivityController controller;

  @Override public void initializeController() {
    ((CervantesApplication) getApplication()).inject(this);
    controller.setFragmentManager(getFragmentManager());
    setController(controller);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main);
  }
}
