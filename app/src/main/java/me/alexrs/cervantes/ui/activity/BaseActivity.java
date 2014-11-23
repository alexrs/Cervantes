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

import android.app.Activity;
import android.os.Bundle;
import me.alexrs.cervantes.ui.controller.ActivityController;

/**
 * @author Alejandro Rodríguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class BaseActivity extends Activity {

  private ActivityController activityController;

  /**
   * In this method you should initialize your controller and call to #setController
   */
  public abstract void initializeController();

  public void setController(ActivityController activityController) {
    this.activityController = activityController;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeController();
    activityController.onCreate(savedInstanceState);
  }

  @Override protected void onStart() {
    super.onStart();
    activityController.onStart();
  }

  @Override protected void onResume() {
    super.onResume();
    activityController.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
    activityController.onPause();
  }

  @Override protected void onStop() {
    super.onStop();
    activityController.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    activityController.onDestroy();
  }

  @Override protected void onRestart() {
    super.onRestart();
    activityController.onRestart();
  }
}
