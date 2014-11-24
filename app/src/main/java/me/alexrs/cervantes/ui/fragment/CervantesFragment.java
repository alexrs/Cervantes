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
