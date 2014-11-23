package me.alexrs.cervantes.ui.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eowise.recyclerview.stickyheaders.StickyHeadersAdapter;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Word;
import me.alexrs.cervantes.ui.recyclerview.viewholder.HeadersViewHolder;

/**
 * @author Alejandro on 23/11/14.
 */
public class HeadersAdapter implements StickyHeadersAdapter<HeadersViewHolder> {

  private List<Word> items;

  public HeadersAdapter(List<Word> items) {
    this.items = items;
  }

  @Override public HeadersViewHolder onCreateViewHolder(ViewGroup container) {
    View itemView =
        LayoutInflater.from(container.getContext()).inflate(R.layout.h_word, container, false);
    return new HeadersViewHolder(itemView);
  }

  @Override public void onBindViewHolder(HeadersViewHolder headersViewHolder, int i) {
    headersViewHolder.title.setText(items.get(i).getWord());
  }

  @Override public long getHeaderId(int i) {
    return i;
  }


}
