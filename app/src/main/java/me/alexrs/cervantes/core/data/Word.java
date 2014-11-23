package me.alexrs.cervantes.core.data;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

public class Word {

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

}
