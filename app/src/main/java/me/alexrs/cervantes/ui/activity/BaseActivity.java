package me.alexrs.cervantes.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import me.alexrs.cervantes.ui.controller.ActivityController;

/**
 * @author Alejandro Rodríguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class BaseActivity extends Activity {

  private ActivityController activityController;

  public abstract void initializeController();

  public void setController(ActivityController activityController) {
    this.activityController = activityController;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeController();
    activityController.onCreate(savedInstanceState);
  }

  @Override protected void onStart() {
    super.onStart();
    activityController.onStart();
  }

  @Override protected void onResume() {
    super.onResume();
    activityController.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
    activityController.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
    activityController.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    activityController.onDestroy();
  }

  @Override protected void onRestart() {
    super.onRestart();
    activityController.onRestart();
  }
}
