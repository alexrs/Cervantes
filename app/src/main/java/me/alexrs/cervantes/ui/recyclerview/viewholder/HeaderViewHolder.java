package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.events.SearchEvent;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro on 23/11/14.
 */
public class HeaderViewHolder extends RenderViewHolder implements TextView.OnEditorActionListener {

  private final Context context;
  @InjectView(R.id.h_image) ImageView header_image;
  @InjectView(R.id.h_edittext) EditText header_editText;

  public HeaderViewHolder(View itemView) {
    super(itemView);
    ButterKnife.inject(this, itemView);
    this.context = itemView.getContext();
  }

  @Override public void onBindView(Renderable renderable) {
    Picasso.with(context).load("http://lorempixel.com/g/400/200/").into(header_image);
    header_editText.setOnEditorActionListener(this);
  }

  @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
      EventBus.getDefault().post(new SearchEvent(header_editText.getText().toString()));
      return true;
    }
    return false;
  }
}
