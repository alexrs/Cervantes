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
package me.alexrs.cervantes.core.data;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class Word implements Renderable {

  @Expose
  private String word;
  @Expose
  private List<Meaning> meanings = new ArrayList<Meaning>();
  @Expose
  private String etymology;

  public Word(String etymology) {
    this.etymology = etymology;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public List<Meaning> getMeanings() {
    return meanings;
  }

  public void setMeanings(List<Meaning> meanings) {
    this.meanings = meanings;
  }

  public String getEtymology() {
    return etymology;
  }

  public void setEtymology(String etymology) {
    this.etymology = etymology;
  }

  @Override public int getRenderableId() {
    return R.layout.h_word;
  }
}
