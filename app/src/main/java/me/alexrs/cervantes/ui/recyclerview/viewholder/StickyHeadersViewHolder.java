package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import me.alexrs.cervantes.R;

/**
 * @author Alejandro on 23/11/14.
 */
public class StickyHeadersViewHolder extends RecyclerView.ViewHolder {

  @InjectView(R.id.h_word_title) public TextView title;
  @InjectView(R.id.h_word_subtitle) public TextView subtitle;

  public StickyHeadersViewHolder(View itemView) {
    super(itemView);
    ButterKnife.inject(this, itemView);
  }
}
