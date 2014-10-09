package me.alexrs.cervantes.core.application;

import android.app.Application;

import dagger.ObjectGraph;
import me.alexrs.cervantes.core.module.CervantesModule;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = initializeGraph();
        objectGraph.inject(this);
    }

    /**
     * Initializes Object graph
     *
     * @return New object graph
     */
    protected ObjectGraph initializeGraph() {
        return ObjectGraph.create(new CervantesModule(this));
    }

    /**
     * Injection facility for the elements.
     *
     * @param instance Instance of the object to inject dependencies
     * @param <T>      Class that will be injected
     */
    public <T> void inject(T instance) {
        objectGraph.inject(instance);
    }

    /**
     * Provider facility for the elements.
     *
     * @param type Type of the instance to get
     * @param <T>  Class that will be injected
     */
    public <T> T get(Class<T> type) {
        return objectGraph.get(type);
    }

    public ObjectGraph getGraph() {
        return objectGraph;
    }
}
