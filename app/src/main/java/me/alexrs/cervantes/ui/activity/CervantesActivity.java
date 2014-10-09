package me.alexrs.cervantes.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import me.alexrs.cervantes.core.application.CervantesApplication;

/**
 * @author Alejandro Rodríguez <https://github.com/Alexrs95/Cervantes>
 */
public abstract class CervantesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CervantesApplication) getApplication()).inject(this);
    }
}
