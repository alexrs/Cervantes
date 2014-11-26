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
package me.alexrs.cervantes.ui.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.InjectView;
import java.util.ArrayList;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Header;
import me.alexrs.cervantes.core.data.MultipleResponseWord;
import me.alexrs.cervantes.core.data.Word;
import me.alexrs.cervantes.ui.recyclerview.factory.Factory;
import me.alexrs.recyclerviewrenderers.adapter.RendererAdapter;
import me.alexrs.recyclerviewrenderers.builder.RendererBuilder;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesFragmentPresenter extends BasePresenter {

  @InjectView(R.id.f_main_recyclerview) RecyclerView recyclerView;

  private List<Renderable> items = new ArrayList<Renderable>();
  private RendererAdapter adapter;

  @Override public void onBindView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(false);
    items.add(new Header());
    adapter = new RendererAdapter(items, new RendererBuilder(new Factory()));
    adapter.setHasStableIds(true);
    recyclerView.setAdapter(adapter);

    //TODO: refactor this.
    recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
      }
    });
  }

  public void setWords(List<Word> words) {
    removeItems();
    items.addAll(getMeanings(words));
    adapter.notifyDataSetChanged();
  }

  /**
   * Remove list items, but not the header
   */
  public void removeItems() {
    int size = items.size();
    for (int i = 1; i < size; i++) {
      items.remove(1);
      adapter.notifyItemRemoved(1);
    }
  }

  private List<Renderable> getMeanings(List<Word> words) {
    List<Renderable> meanings = new ArrayList<Renderable>();
    for (Word word : words) {
      meanings.add(word);
      meanings.addAll(word.getMeanings());
    }
    return meanings;
  }

  public void setWordsMultiple(List<Word> words) {
    removeItems();
    items.add(
        new Word(recyclerView.getContext().getResources().getString(R.string.multiple_response)));
    for (Word word : words) {
      items.add(new MultipleResponseWord(word));
    }
    adapter.notifyDataSetChanged();
  }
}
