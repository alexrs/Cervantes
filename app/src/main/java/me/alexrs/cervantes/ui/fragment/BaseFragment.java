/*
 * Copyright (C) 2014 Alejandro Rodriguez Salamanca.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.alexrs.cervantes.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.ui.controller.fragment.FragmentController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class BaseFragment extends Fragment {

  FragmentController fragmentController;

  /**
   * In this method you should initialize your controller and call to #setController
   */
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
