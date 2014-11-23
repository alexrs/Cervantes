package me.alexrs.cervantes.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.ui.controller.ActivityController;
import me.alexrs.cervantes.ui.controller.FragmentController;

/**
 * @author Alejandro Rodriguez
 */
public abstract class BaseFragment extends Fragment {

  FragmentController fragmentController;

  public abstract void initializeController();

  public void setController(FragmentController activityController){
    this.fragmentController = activityController;
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    initializeController();
    fragmentController.onAttach(activity);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    fragmentController.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return fragmentController.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    fragmentController.onViewCreated(view, savedInstanceState);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    fragmentController.onActivityCreated(savedInstanceState);
  }

  @Override public void onStart() {
    super.onStart();
    fragmentController.onStart();
  }

  @Override public void onResume() {
    super.onResume();
    fragmentController.onResume();
  }

  @Override public void onPause() {
    super.onPause();
    fragmentController.onPause();
  }

  @Override public void onStop() {
    super.onStop();
    fragmentController.onStop();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    fragmentController.onDestroyView();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    fragmentController.onDestroy();
  }

  @Override public void onDetach() {
    super.onDetach();
    fragmentController.onDetach();
  }
}
