/*
 * Copyright (C) 2014 Alejandro Rodriguez Salamanca.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.alexrs.cervantes.ui.recyclerview.factory;

import android.support.annotation.LayoutRes;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemMeaning;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemMultipleWords;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemSearchHeader;
import me.alexrs.cervantes.ui.recyclerview.renderers.ItemWordHeader;
import me.alexrs.recyclerviewrenderers.interfaces.RendererFactory;
import me.alexrs.recyclerviewrenderers.renderer.Renderer;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class Factory implements RendererFactory {

  @Override public Renderer getRenderer(@LayoutRes int id) {
    switch (id) {
      case R.layout.i_meaning:
        return new ItemMeaning(id);
      case R.layout.h_search:
        return new ItemSearchHeader(id);
      case R.layout.h_word:
        return new ItemWordHeader(id);
      case R.layout.i_multiple_words:
        return new ItemMultipleWords(id);
    }
    return null;
  }
}
