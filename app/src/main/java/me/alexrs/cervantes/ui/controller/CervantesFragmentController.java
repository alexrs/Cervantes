package me.alexrs.cervantes.ui.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.path.android.jobqueue.JobManager;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import javax.inject.Inject;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Nebrija;
import me.alexrs.cervantes.core.data.Word;
import me.alexrs.cervantes.core.jobs.GetWordJob;
import me.alexrs.cervantes.ui.presenter.CervantesFragmentPresenter;
import me.alexrs.cervantes.ui.presenter.EmptyViewPresenter;

/**
 * @author Alejandro on 09/09/14.
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
    jobManager.addJobInBackground(new GetWordJob("wHzIYMmRVDXX2tX1bpuy"));
    return rootView;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    emptyViewPresenter.showView(EmptyViewPresenter.SHOW_PROGRESS);
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
   * This method is called by EventBus when the response is received
   */
  public void onEventMainThread(Nebrija nebrija) {
    emptyViewPresenter.showView(EmptyViewPresenter.HIDE);
    mainPresenter.setWords(nebrija.getWords());
  }
}
