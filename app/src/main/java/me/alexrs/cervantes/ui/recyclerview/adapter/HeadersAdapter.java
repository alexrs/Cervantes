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
package me.alexrs.cervantes.ui.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eowise.recyclerview.stickyheaders.StickyHeadersAdapter;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Meaning;
import me.alexrs.cervantes.core.data.Word;
import me.alexrs.cervantes.ui.recyclerview.viewholder.WordHeadersViewHolder;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class HeadersAdapter implements StickyHeadersAdapter<WordHeadersViewHolder> {

  private List<Meaning> meanings;
  private List<Word> words;
  int i = 0;
  int size = 0;

  public HeadersAdapter(List<Word> words, List<Meaning> meanings) {
    this.words = words;
    this.meanings = meanings;
    size = meanings.size();
  }

  @Override public WordHeadersViewHolder onCreateViewHolder(ViewGroup container) {
    View itemView =
        LayoutInflater.from(container.getContext()).inflate(R.layout.h_word, container, false);
    return new WordHeadersViewHolder(itemView);
  }

  @Override public void onBindViewHolder(WordHeadersViewHolder headersViewHolder, int position) {
    if (i > 0) {
      headersViewHolder.title.setText(words.get(i - 1).getWord());
      headersViewHolder.subtitle.setText(words.get(i - 1).getEtymology());
    }
  }

  @Override public long getHeaderId(int position) {
    if (words.get(i).getMeanings().size() >= size) {
      i++;
      size = 0;
    }
    size++;
    return i;
  }
}
