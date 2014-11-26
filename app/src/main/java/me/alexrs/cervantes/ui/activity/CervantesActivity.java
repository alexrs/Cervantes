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
package me.alexrs.cervantes.ui.activity;

import android.os.Bundle;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.ui.controller.activity.CervantesActivityController;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesActivity extends BaseActivity {

  @Inject CervantesActivityController controller;

  @Override public void initializeController() {
    ((CervantesApplication) getApplication()).inject(this);
    controller.setFragmentManager(getFragmentManager());
    setController(controller);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.a_main);
  }
}
