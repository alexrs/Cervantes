package me.alexrs.cervantes.core.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author Alejandro on 27/07/14.
 */
public class MeaningsResponse {

  @SerializedName("word")
  private String word;
  @SerializedName("meta")
  private String meta;

  public String getWord() {
    return word;
  }

  public String getMeta() {
    return meta;
  }
}
