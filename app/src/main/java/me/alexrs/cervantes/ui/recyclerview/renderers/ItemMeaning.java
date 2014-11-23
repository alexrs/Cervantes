package me.alexrs.cervantes.ui.recyclerview.renderers;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.ui.recyclerview.viewholder.ViewHolderMeaning;
import me.alexrs.recyclerviewrenderers.renderer.Renderer;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro on 21/11/14.
 */
public class ItemMeaning extends Renderer {

  public ItemMeaning(int id) {
    super(id);
  }

  @Override public RenderViewHolder onCreateViewHolder(ViewGroup viewGroup, @LayoutRes int id) {
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(id, viewGroup, false);
    return new ViewHolderMeaning(itemView);
  }
}
