package me.alexrs.cervantes.core.preferences;

import android.content.SharedPreferences;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class PreferencesManager {

  private final SharedPreferences reader;
  private final SharedPreferences.Editor editor;

  public PreferencesManager(SharedPreferences reader, SharedPreferences.Editor editor) {
    this.reader = reader;
    this.editor = editor;
  }
}
