package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.MultipleResponseWord;
import me.alexrs.cervantes.core.events.SearchEvent;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro on 27/11/14.
 */
public class MultipleWordsViewHolder extends RenderViewHolder<MultipleResponseWord>
    implements View.OnClickListener {

  @InjectView(R.id.tv_multiple) TextView tvWord;
  private String id;

  public MultipleWordsViewHolder(View itemView) {
    super(itemView);
    itemView.setOnClickListener(this);
    ButterKnife.inject(this, itemView);
  }

  @Override public void onBindView(MultipleResponseWord renderable) {
    id = renderable.getWord().getId();
    tvWord.setText(renderable.getWord().getWord());
  }

  @Override public void onClick(View v) {
    EventBus.getDefault().post(new SearchEvent(id));
  }
}
