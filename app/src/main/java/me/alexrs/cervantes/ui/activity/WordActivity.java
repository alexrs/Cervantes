package me.alexrs.cervantes.ui.activity;

import android.os.Bundle;

import me.alexrs.cervantes.R;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class WordActivity extends CervantesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_word);
    }
}
