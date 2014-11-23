package me.alexrs.cervantes.core.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.path.android.jobqueue.JobManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.core.preferences.PreferencesManager;
import me.alexrs.cervantes.ui.activity.BaseActivity;
import me.alexrs.cervantes.ui.activity.CervantesActivity;
import me.alexrs.cervantes.ui.controller.CervantesActivityController;
import me.alexrs.cervantes.ui.controller.CervantesFragmentController;
import me.alexrs.cervantes.ui.fragment.BaseFragment;
import me.alexrs.cervantes.ui.fragment.CervantesFragment;
import me.alexrs.cervantes.ui.presenter.CervantesActivityPresenter;
import me.alexrs.cervantes.ui.presenter.CervantesFragmentPresenter;
import me.alexrs.cervantes.ui.presenter.EmptyViewPresenter;

/**
 * @author Alejandro Rodriguez <alex95@gmil.com>
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
   * Provides a full singleton instance of Preferences Manager
   *
   * @param reader Preferences reader to inject
   * @param editor Preferences editor to inject
   * @return Singleton instance of the Preferences Manager
   */
  @Provides @Singleton public PreferencesManager providePreferencesManager(SharedPreferences reader,
      SharedPreferences.Editor editor) {
    return new PreferencesManager(reader, editor);
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
   * Provides a singleton Shared Preferences reader
   *
   * @param context Context of the Application to instantiate the preferences
   * @return Singleton instance of the Shared Preferences reader
   */
  @Provides @Singleton public SharedPreferences providePreferences(Context context) {
    return context.getSharedPreferences("", Context.MODE_PRIVATE);
  }

  /**
   * Provides a singleton Shared Preferences editor
   *
   * @param preferences Preferences reader to add the editor from
   * @return Singleton instance of the Shared Preferences editor
   */
  @Provides @Singleton public SharedPreferences.Editor providePreferencesEditor(
      SharedPreferences preferences) {
    return preferences.edit();
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

  @Provides public CervantesActivityPresenter provideMainActivityPresenter() {
    return new CervantesActivityPresenter();
  }

  @Provides public CervantesFragmentPresenter provideMainPresenter() {
    return new CervantesFragmentPresenter();
  }

  @Provides public CervantesActivityController provideMainActivityController(
      CervantesActivityPresenter presenter) {
    return new CervantesActivityController(presenter);
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
