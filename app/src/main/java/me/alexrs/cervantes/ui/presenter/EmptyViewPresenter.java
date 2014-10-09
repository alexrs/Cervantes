package me.alexrs.cervantes.ui.presenter;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.InjectView;
import me.alexrs.cervantes.R;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class EmptyViewPresenter extends CervantesPresenter {

    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.l_error)
    LinearLayout lError;
    @InjectView(R.id.tv_meaning)
    TextView tvError;
    @InjectView(R.id.button)
    Button btRetry;

    /**
     *
     */
    public static final int SHOW_PROGRESS = 0;
    /**
     *
     */
    public static final int SHOW_ERROR = 1;

    /**
     * @param view
     */
    public void showView(int view) {

    }

    @Override
    public void hookUpListeners() {

    }
}
