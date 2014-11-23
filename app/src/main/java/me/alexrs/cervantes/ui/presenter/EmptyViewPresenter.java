package me.alexrs.cervantes.ui.presenter;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import me.alexrs.cervantes.R;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class EmptyViewPresenter extends CervantesBasePresenter {

  @InjectView(R.id.progressBar) ProgressBar progressBar;
  @InjectView(R.id.l_error) LinearLayout lError;
  @InjectView(R.id.tv_meaning) TextView tvError;
  @InjectView(R.id.bt_error) Button btError;

  /**
   * Constant code for show progress
   */
  public static final int SHOW_PROGRESS = 0;
  /**
   * Constant code for show error
   */
  public static final int SHOW_ERROR = 1;

  /**
   * Constant code for hide the views
   */
  public static final int HIDE = 2;

  /**
   * @param view SHOW_PROGRESS, SHOW_ERROR or HIDE
   */
  public void showView(int view) {
    switch (view) {
      case SHOW_PROGRESS:
        lError.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        break;
      case SHOW_ERROR:
        lError.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        break;
      case HIDE:
        lError.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        break;
    }
  }

  public void setErrorText(String error) {
    tvError.setText(error);
  }

  public void setErrorButtonText(String error) {
    btError.setText(error);
  }

  @OnClick(R.id.bt_error)
  public void retry() {
  }

  @Override
  public void hookUpListeners() {
  }

  @Override
  public void onViewCreated() {

  }
}
