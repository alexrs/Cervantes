package me.alexrs.cervantes.ui.recyclerview.factory;

import android.support.annotation.LayoutRes;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemHeader;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemMeaning;
import me.alexrs.recyclerviewrenderers.interfaces.RendererFactory;
import me.alexrs.recyclerviewrenderers.renderer.Renderer;

/**
 * @author Alejandro on 21/11/14.
 */
public class Factory implements RendererFactory {

  @Override public Renderer getRenderer(@LayoutRes int id) {
    switch (id){
      case R.layout.i_meaning:
        return new ItemMeaning(id);
      case R.layout.h_edit_text:
        return new ItemHeader(id);
    }
    return null;
  }
}
