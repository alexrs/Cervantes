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
package me.alexrs.cervantes.core.jobs;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import de.greenrobot.event.EventBus;
import me.alexrs.cervantes.core.data.Nebrija;
import me.alexrs.cervantes.core.events.SearchFailed;
import me.alexrs.cervantes.core.events.SearchPerformed;
import me.alexrs.cervantes.core.network.client.RestClient;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 *
 *         Job that permorm a request to get the meanign of a word
 */
public class GetWordJob extends Job {

  private static final int PRIORITY = 0;
  private final String word;

  public GetWordJob(String word) {
    super(new Params(PRIORITY).requireNetwork());
    this.word = word;
  }

  @Override
  public void onAdded() {
    EventBus.getDefault().post(new SearchPerformed());
  }

  @Override
  public void onRun() throws Throwable {
    Nebrija response = RestClient.get().getWord(word);
    EventBus.getDefault().post(response);
  }

  @Override
  protected void onCancel() {
    EventBus.getDefault().post(new SearchFailed());
  }

  @Override
  protected boolean shouldReRunOnThrowable(Throwable throwable) {
    EventBus.getDefault().post(new SearchFailed());
    return false;
  }
}
