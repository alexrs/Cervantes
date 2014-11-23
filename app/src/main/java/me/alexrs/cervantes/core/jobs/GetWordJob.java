package me.alexrs.cervantes.core.jobs;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import me.alexrs.cervantes.core.data.Nebrija;
import me.alexrs.cervantes.core.network.api.NebrijaApi;
import retrofit.RestAdapter;

/**
 * @author Alejandro on 16/11/14.
 */
public class GetWordJob extends Job {


  private static final int PRIORITY = 0;
  private final String word;

  public GetWordJob(String word) {
    super(new Params(PRIORITY).requireNetwork().persist());
    this.word = word;
  }

  @Override
  public void onAdded() {

  }

  @Override
  public void onRun() throws Throwable {
    RestAdapter restAdapter =
        new RestAdapter.Builder().setEndpoint("http://dulcinea.herokuapp.com/").build();
    NebrijaApi service = restAdapter.create(NebrijaApi.class);
    Nebrija response = service.getWord(word);
    EventBus.getDefault().post(response);
  }

  @Override
  protected void onCancel() {

  }

  @Override
  protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}
