package me.alexrs.cervantes.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Alejandro on 06/11/14.
 */
public interface AbsFragmentController {

  void onAttach(Activity activity);

  void onCreate(Bundle savedInstanceState);

  /**
   * @param inflater
   * @param container
   * @param id
   * @return
   */
  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle id);

  /**
   *
   * @param view
   * @param savedInstanceState
   */
  void onViewCreated(View view, Bundle savedInstanceState);

  void onActivityCreated(Bundle savedInstanceState);

  void onStart();

  void onResume();

  void onPause();

  void onDestroyView();

  void onDestroy();

  void onDetach();

  void onStop();

}
