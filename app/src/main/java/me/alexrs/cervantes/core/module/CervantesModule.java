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
package me.alexrs.cervantes.core.module;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.path.android.jobqueue.JobManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.ui.activity.BaseActivity;
import me.alexrs.cervantes.ui.activity.CervantesActivity;
import me.alexrs.cervantes.ui.controller.activity.CervantesActivityController;
import me.alexrs.cervantes.ui.controller.fragment.CervantesFragmentController;
import me.alexrs.cervantes.ui.fragment.BaseFragment;
import me.alexrs.cervantes.ui.fragment.CervantesFragment;
import me.alexrs.cervantes.ui.presenter.CervantesFragmentPresenter;
import me.alexrs.cervantes.ui.presenter.EmptyViewPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
@Module(
    complete = false,
    library = true,
    injects = {
        //Application
        CervantesApplication.class,
        //Activities
        BaseActivity.class, CervantesActivity.class,
        //Fragments
        BaseFragment.class, CervantesFragment.class
    })
public class CervantesModule {

  protected Context context;

  public CervantesModule(Context context) {
    this.context = context.getApplicationContext();
  }

  /**
   * Provides an Application Context
   *
   * @return Application Context
   */
  @Provides @Singleton Context provideContext() {
    return context;
  }

  /**
   * Provides new Resources instance
   *
   * @param context Context to obtain the Resources form
   */
  @Singleton @Provides public Resources provideResources(Context context) {
    return context.getResources();
  }

  /**
   * Provides an instance of LayoutInflater
   *
   * @return instance of LayoutInfltater
   */
  @Provides public LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(context);
  }

  @Provides public EmptyViewPresenter provideEmptyViewPresenter() {
    return new EmptyViewPresenter();
  }

  @Provides public CervantesFragmentPresenter provideMainPresenter() {
    return new CervantesFragmentPresenter();
  }

  @Provides public CervantesActivityController provideMainActivityController() {
    return new CervantesActivityController();
  }

  @Provides public CervantesFragmentController provideMainController(
      CervantesFragmentPresenter mainPresenter, EmptyViewPresenter emptyViewPresenter,
      JobManager jobManager) {
    return new CervantesFragmentController(mainPresenter, emptyViewPresenter, jobManager);
  }

  @Provides @Singleton public JobManager provideJobManager(Context context) {
    return new JobManager(context);
  }
}
