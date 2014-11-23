package me.alexrs.cervantes.ui.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.InjectView;
import java.util.ArrayList;
import java.util.List;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Header;
import me.alexrs.cervantes.core.data.Meaning;
import me.alexrs.cervantes.core.data.Word;
import me.alexrs.cervantes.ui.recyclerview.factory.Factory;
import me.alexrs.recyclerviewrenderers.adapter.RendererAdapter;
import me.alexrs.recyclerviewrenderers.builder.RendererBuilder;
import me.alexrs.recyclerviewrenderers.interfaces.Renderable;

/**
 * @author Alejandro
 */
public class CervantesFragmentPresenter extends CervantesBasePresenter {

  @InjectView(R.id.f_main_recyclerview) RecyclerView recyclerView;

  private List<Renderable> items = new ArrayList<Renderable>();
  private RendererAdapter adapter;
  //  private StickyHeadersBuilder headerBuilder;

  @Override
  public void hookUpListeners() {

    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(layoutManager);
    items.add(new Header());
    adapter = new RendererAdapter(items, new RendererBuilder(new Factory()));
    recyclerView.setAdapter(adapter);

    //    headerBuilder = new StickyHeadersBuilder().setAdapter(adapter).setRecyclerView(recyclerView);
  }

  @Override
  public void onViewCreated() {
    //
  }

  public void setWords(List<Word> words) {
    //  StickyHeadersItemDecoration header =
    //       headerBuilder.setStickyHeadersAdapter(new HeadersAdapter(words)).build();
    //    recyclerView.addItemDecoration(header);
    removeItems();
    items.addAll(getMeanings(words));
    adapter.notifyDataSetChanged();
  }

  /**
   * Remove list items, but not the header
   */
  private void removeItems() {
    int size = items.size();
    for (int i = 1; i < size; i++) {
      items.remove(1);
    }
  }

  private List<Meaning> getMeanings(List<Word> words) {
    List<Meaning> meanings = new ArrayList<Meaning>();
    for (Word word : words) {
      meanings.addAll(word.getMeanings());
    }
    return meanings;
  }
}
