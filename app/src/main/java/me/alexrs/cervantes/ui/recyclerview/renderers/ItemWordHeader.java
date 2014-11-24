package me.alexrs.cervantes.ui.recyclerview.renderers;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.recyclerview.viewholder.WordHeadersViewHolder;
import me.alexrs.recyclerviewrenderers.renderer.Renderer;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro on 24/11/14.
 */
public class ItemWordHeader extends Renderer {

  public ItemWordHeader(@LayoutRes int id) {
    super(id);
  }

  @Override public RenderViewHolder onCreateViewHolder(ViewGroup viewGroup, @LayoutRes int id) {
    View itemView =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_word, viewGroup, false);
    return new WordHeadersViewHolder(itemView);
  }
}
