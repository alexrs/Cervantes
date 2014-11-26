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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.path.android.jobqueue.JobManager;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Nebrija;
import me.alexrs.cervantes.core.events.SearchEvent;
import me.alexrs.cervantes.core.jobs.GetWordJob;
import me.alexrs.cervantes.ui.presenter.CervantesFragmentPresenter;
import me.alexrs.cervantes.ui.presenter.EmptyViewPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesFragmentController extends FragmentController {

  @Inject JobManager jobManager;
  @Inject CervantesFragmentPresenter mainPresenter;
  @Inject EmptyViewPresenter emptyViewPresenter;

  public CervantesFragmentController(CervantesFragmentPresenter mainPresenter,
      EmptyViewPresenter emptyViewPresenter, JobManager jobManager) {
    this.mainPresenter = mainPresenter;
    this.emptyViewPresenter = emptyViewPresenter;
    this.jobManager = jobManager;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle id) {
    View rootView = inflater.inflate(R.layout.f_main, container, false);
    mainPresenter.onCreateView(rootView);
    emptyViewPresenter.onCreateView(rootView);
    emptyViewPresenter.showView(EmptyViewPresenter.HIDE);
    return rootView;
  }

  @Override public void onStart() {
    super.onStart();
    EventBus.getDefault().register(this);
  }

  @Override public void onPause() {
    super.onPause();
    EventBus.getDefault().unregister(this);
  }

  /**
   * This method is called when the response is received
   */
  public void onEventMainThread(Nebrija nebrija) {
    emptyViewPresenter.showView(EmptyViewPresenter.HIDE);
    mainPresenter.setWords(nebrija.getWords());
  }

  /**
   * This method is called when a search is done
   */
  public void onEvent(SearchEvent searchEvent) {
    emptyViewPresenter.showView(EmptyViewPresenter.SHOW_PROGRESS);
    jobManager.addJobInBackground(new GetWordJob(searchEvent.getSearch()));
  }
}
