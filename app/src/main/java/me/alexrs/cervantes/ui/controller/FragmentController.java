package me.alexrs.cervantes.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Alejandro on 22/11/14.
 */
public abstract class FragmentController implements AbsFragmentController {

  @Override public void onAttach(Activity activity) {

  }

  @Override public void onCreate(Bundle savedInstanceState) {

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle id) {
    return null;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {

  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {

  }

  @Override public void onStart() {

  }

  @Override public void onResume() {

  }

  @Override public void onPause() {

  }

  @Override public void onStop() {

  }

  @Override public void onDestroyView() {

  }

  @Override public void onDestroy() {

  }

  @Override public void onDetach() {

  }
}
