package me.alexrs.cervantes.core.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.core.application.CervantesApplication;
import me.alexrs.cervantes.core.preferences.PreferencesManager;
import me.alexrs.cervantes.ui.activity.CervantesActivity;
import me.alexrs.cervantes.ui.activity.MainActivity;
import me.alexrs.cervantes.ui.activity.WordActivity;
import me.alexrs.cervantes.ui.controller.FavsController;
import me.alexrs.cervantes.ui.controller.MainActivityController;
import me.alexrs.cervantes.ui.controller.MainController;
import me.alexrs.cervantes.ui.controller.SearchController;
import me.alexrs.cervantes.ui.controller.WordController;
import me.alexrs.cervantes.ui.fragment.CervantesFragment;
import me.alexrs.cervantes.ui.fragment.DisambiguationFrgment;
import me.alexrs.cervantes.ui.fragment.FavsFragment;
import me.alexrs.cervantes.ui.fragment.HistoryFragment;
import me.alexrs.cervantes.ui.fragment.MainFragment;
import me.alexrs.cervantes.ui.fragment.SearchFragment;
import me.alexrs.cervantes.ui.fragment.WordFragment;
import me.alexrs.cervantes.ui.presenter.EmptyViewPresenter;
import me.alexrs.cervantes.ui.presenter.FavsPresenter;
import me.alexrs.cervantes.ui.presenter.MainActivityPresenter;
import me.alexrs.cervantes.ui.presenter.MainPresenter;
import me.alexrs.cervantes.ui.presenter.SearchPresenter;
import me.alexrs.cervantes.ui.presenter.WordPresenter;

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
                CervantesActivity.class,
                MainActivity.class,
                WordActivity.class,
                //Fragments
                CervantesFragment.class,
                DisambiguationFrgment.class,
                FavsFragment.class,
                HistoryFragment.class,
                MainFragment.class,
                SearchFragment.class,
                WordFragment.class
        }
)
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
    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    /**
     * Provides a new Event Bus
     *
     * @return Singleton bus
     */
    @Provides
    @Singleton
    public EventBus provideBus() {
        return new EventBus();
    }

    /**
     * Provides a full singleton instance of Preferences Manager
     *
     * @param reader Preferences reader to inject
     * @param editor Preferences editor to inject
     * @return Singleton instance of the Preferences Manager
     */
    @Provides
    @Singleton
    public PreferencesManager providePreferencesManager(SharedPreferences reader, SharedPreferences.Editor editor) {
        return new PreferencesManager(reader, editor);
    }

    /**
     * Provides new Resources instance
     *
     * @param context Context to obtain the Resources form
     * @return
     */
    @Singleton
    @Provides
    public Resources provideResources(Context context) {
        return context.getResources();
    }

    /**
     * Provides a singleton Shared Preferences reader
     *
     * @param context Context of the Application to instantiate the preferences
     * @return Singleton instance of the Shared Preferences reader
     */
    @Provides
    @Singleton
    public SharedPreferences providePreferences(Context context) {
        return context.getSharedPreferences("", Context.MODE_PRIVATE);
    }

    /**
     * Provides a singleton Shared Preferences editor
     *
     * @param preferences Preferences reader to add the editor from
     * @return Singleton instance of the Shared Preferences editor
     */
    @Provides
    @Singleton
    public SharedPreferences.Editor providePreferencesEditor(SharedPreferences preferences) {
        return preferences.edit();
    }


    /**
     * Provides an instance of LayoutInflater
     *
     * @return instance of LayoutInfltater
     */
    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    @Provides
    public EmptyViewPresenter provideEmptyViewPresenter() {
        return new EmptyViewPresenter();
    }

    @Provides
    public WordPresenter provideWordPresenter() {
        return new WordPresenter();
    }

    @Provides
    public MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter();
    }

    @Provides
    public SearchPresenter provideSearchPresenter(EventBus eventBus) {
        return new SearchPresenter(eventBus);
    }

    @Provides
    public FavsPresenter provideFavsPresenter() {
        return new FavsPresenter();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    public WordController provideWordController(WordPresenter presenter) {
        return new WordController(presenter);
    }

    @Provides
    public MainActivityController provideMainActivityController(MainActivityPresenter presenter) {
        return new MainActivityController(presenter);
    }

    @Provides
    public SearchController provideSearchController(EventBus eventBus, SearchPresenter presenter) {
        return new SearchController(presenter, eventBus, context);
    }

    @Provides
    public FavsController provideFavsController() {
        return new FavsController();
    }

    @Provides
    public MainController provideMainController(MainPresenter presenter) {
        return new MainController(presenter);
    }

}
