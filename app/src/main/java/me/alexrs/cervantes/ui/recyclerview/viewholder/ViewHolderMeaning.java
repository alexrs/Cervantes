package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Meaning;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro on 21/11/14.
 */
public class ViewHolderMeaning extends RenderViewHolder<Meaning> {

  @InjectView(R.id.textView) TextView textView;

  public ViewHolderMeaning(View itemView) {
    super(itemView);
    ButterKnife.inject(this, itemView);
  }

  @Override public void onBindView(Meaning meaning) {
    textView.setText(meaning.getMeaning());
  }
}
