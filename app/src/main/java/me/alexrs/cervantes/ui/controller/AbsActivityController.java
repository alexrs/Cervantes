package me.alexrs.cervantes.ui.controller;

import android.os.Bundle;

/**
 * @author Alejandro on 06/11/14.
 */
public interface AbsActivityController {

  /**
   *
   * @param savedInstanceState
   */
  void onCreate(Bundle savedInstanceState);

  void onStart();

  void onResume();

  void onPause();

  void onRestart();

  void onDestroy();

  void onStop();
}
