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
package me.alexrs.cervantes.ui.recyclerview.renderers;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.ui.recyclerview.viewholder.SearchHeaderViewHolder;
import me.alexrs.recyclerviewrenderers.renderer.Renderer;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;


/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class ItemSearchHeader extends Renderer {

  public ItemSearchHeader(@LayoutRes int id) {
    super(id);
  }

  @Override public RenderViewHolder onCreateViewHolder(ViewGroup viewGroup, @LayoutRes int id) {
    View itemView =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h_search, viewGroup, false);
    return new SearchHeaderViewHolder(itemView);
  }
}
