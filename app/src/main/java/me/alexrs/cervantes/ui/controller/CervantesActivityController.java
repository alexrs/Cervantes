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

import android.app.FragmentManager;
import android.os.Bundle;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.fragment.CervantesFragment;
import me.alexrs.cervantes.ui.presenter.CervantesActivityPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesActivityController extends ActivityController {

  @Inject CervantesActivityPresenter presenter;
  private FragmentManager fragmentManager;

  public CervantesActivityController(CervantesActivityPresenter presenter) {
    this.presenter = presenter;
  }

  public void setFragmentManager(FragmentManager fragmentManager) {
    this.fragmentManager = fragmentManager;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    fragmentManager.beginTransaction().replace(R.id.container, new CervantesFragment()).commit();
  }
}
