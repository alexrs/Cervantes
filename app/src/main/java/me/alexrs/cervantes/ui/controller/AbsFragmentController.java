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
package me.alexrs.cervantes.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Alejandro Rodríguez <https://github.com/Alexrs95/Cervantes>
 *
 *         In this interface are declared the method of the Fragment lifecycle
 */
public interface AbsFragmentController {

  void onAttach(Activity activity);

  void onCreate(Bundle savedInstanceState);

  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle id);

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
