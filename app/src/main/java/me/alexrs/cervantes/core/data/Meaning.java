package me.alexrs.cervantes.core.data;

import com.google.gson.annotations.Expose;
import me.alexrs.cervantes.R;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

public class Meaning implements Renderable {

  @Expose
  private String meaning;
  @Expose
  private String meta;

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public String getMeta() {
    return meta;
  }

  public void setMeta(String meta) {
    this.meta = meta;
  }

  @Override public int getRenderableId() {
    return R.layout.i_meaning;
  }

}
