package me.alexrs.cervantes.core.data;

import me.alexrs.cervantes.R;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

/**
 * @author Alejandro on 23/11/14.
 */
public class Header implements Renderable {
  @Override public int getRenderableId() {
    return R.layout.h_edit_text;
  }
}
