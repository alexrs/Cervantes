package me.alexrs.cervantes.core.data;

import me.alexrs.cervantes.R;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

/**
 * @author Alejandro on 27/11/14.
 */
public class MultipleResponseWord implements Renderable{

  private Word word;

  public MultipleResponseWord(Word word) {
    this.word = word;
  }

  @Override public int getRenderableId() {
    return R.layout.i_multiple_words;
  }

  public Word getWord() {
    return word;
  }
}
