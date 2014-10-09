package me.alexrs.cervantes.ui.controller;

import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.event.SearchEvent;
import me.alexrs.cervantes.ui.fragment.WordFragment;
import me.alexrs.cervantes.ui.presenter.SearchPresenter;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class SearchController implements Controller {

    SearchPresenter presenter;
    EventBus bus;
    Context context;
    FragmentManager fragmentManager;

    public SearchController(SearchPresenter presenter, EventBus bus, Context context) {
        this.presenter = presenter;
        this.bus = bus;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, int id) {
        View rootView = inflater.inflate(id, container, false);
        presenter.onCreateView(rootView);
        return rootView;
    }

    @Override
    public void onCreate() {
        bus.register(this);
    }

    @Override
    public void onStop() {
        bus.unregister(this);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }


    public void onEventMainThread(SearchEvent event) {
        //TODO: perform the request!
        Toast.makeText(context, event.getQuery(), Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new WordFragment())
                .commit();
    }

}
