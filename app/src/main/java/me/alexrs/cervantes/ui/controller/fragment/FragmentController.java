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
package me.alexrs.cervantes.ui.controller.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.ui.controller.fragment.AbsFragmentController;

/**
 * @author Alejandro Rodríguez <https://github.com/Alexrs95/Cervantes>
 *
 *         Abstract class that implements {@see me.alexrs.cervantes.ui.controller.fragment.AbsFragmentController}
 *
 *         The Fragment controllers must extends this class and override the methods you want to
 *         use
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
