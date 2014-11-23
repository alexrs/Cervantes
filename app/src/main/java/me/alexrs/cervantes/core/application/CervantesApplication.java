/*
 * Copyright (C) 2014 Alejandro Rodriguez Salamanca.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.alexrs.cervantes.core.application;

import android.app.Application;
import dagger.ObjectGraph;
import java.util.List;
import me.alexrs.cervantes.core.module.CervantesModule;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class CervantesApplication extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(getModules());
    objectGraph.inject(this);
    objectGraph.injectStatics();
  }

  /**
   * Injection facility for the elements.
   *
   * @param instance Instance of the object to inject dependencies
   * @param <T> Class that will be injected
   */
  public <T> void inject(T instance) {
    objectGraph.inject(instance);
  }

  /**
   * Provider facility for the elements.
   *
   * @param type Type of the instance to get
   * @param <T> Class that will be injected
   */
  public <T> T get(Class<T> type) {
    return objectGraph.get(type);
  }

  public ObjectGraph getGraph() {
    return objectGraph;
  }

  /**
   * @return the modules that will be passed to the ObjectGraph
   */
  private Object[] getModules() {
    return new Object[] {
        new CervantesModule(this)
    };
  }

  /**
   *
   * @param modules to add to the ObjectGraph
   * @return the ObjectGraph with the modules added
   */
  public ObjectGraph plus(List<Object> modules) {
    return objectGraph.plus(modules.toArray());
  }
}
