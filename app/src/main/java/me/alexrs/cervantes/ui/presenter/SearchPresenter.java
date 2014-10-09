package me.alexrs.cervantes.ui.presenter;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.event.SearchEvent;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class SearchPresenter extends CervantesPresenter implements TextView.OnEditorActionListener {

    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.bt_search)
    Button btSearch;

    final EventBus eventBus;

    public SearchPresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void hookUpListeners() {
        etSearch.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            performSearch();
            return true;
        }
        return false;
    }

    /**
     * Post an event containing the text to search
     */
    @OnClick(R.id.bt_search)
    protected void performSearch() {
        eventBus.post(new SearchEvent(etSearch.getText().toString()));
    }
}
