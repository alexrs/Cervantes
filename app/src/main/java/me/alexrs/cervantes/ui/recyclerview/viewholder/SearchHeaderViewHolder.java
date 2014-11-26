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
package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.events.SearchEvent;
import me.alexrs.prefs.lib.Prefs;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class SearchHeaderViewHolder extends RenderViewHolder
    implements TextView.OnEditorActionListener {

  private final Context context;
  @InjectView(R.id.h_image) ImageView header_image;
  @InjectView(R.id.h_edittext) EditText header_editText;

  public SearchHeaderViewHolder(View itemView) {
    super(itemView);
    ButterKnife.inject(this, itemView);
    this.context = itemView.getContext();
  }

  @Override public void onBindView(Renderable renderable) {
    Picasso.with(context).load("http://lorempixel.com/400/200/").into(header_image);
    header_editText.setOnEditorActionListener(this);
  }

  @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
      Prefs.with(header_editText.getContext()).save("WORD", header_editText.getText().toString());
      EventBus.getDefault().post(new SearchEvent(header_editText.getText().toString()));
      return true;
    }
    return false;
  }
}
