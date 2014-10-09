package me.alexrs.cervantes.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;

import me.alexrs.cervantes.core.application.CervantesApplication;

/**
 * @author Alejandro Rodriguez <alexrs95@gmai.com>>
 */
public abstract class CervantesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CervantesApplication) getActivity().getApplication()).inject(this);
    }
}
