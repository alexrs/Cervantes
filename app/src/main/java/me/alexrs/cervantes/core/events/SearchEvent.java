package me.alexrs.cervantes.core.events;

/**
 * @author Alejandro on 23/11/14.
 */
public class SearchEvent {

  private String search;

  public SearchEvent(String search) {
    this.search = search;
  }

  public String getSearch() {
    return search;
  }
}
