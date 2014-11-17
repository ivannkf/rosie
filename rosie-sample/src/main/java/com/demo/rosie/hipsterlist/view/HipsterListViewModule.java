package com.demo.rosie.hipsterlist.view;

import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCase;
import com.demo.rosie.hipsterlist.view.activity.phone.HipsterListActivity;
import com.demo.rosie.hipsterlist.view.adapter.FeedAdapter;
import com.demo.rosie.hipsterlist.view.presenter.HipsterListPresenter;
import com.rosie.daggerutils.DomainBus;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(
    library = true,
    complete = false,
    injects = { HipsterListActivity.class }
)
public class HipsterListViewModule {

  @Provides
  public HipsterListPresenter provideHipsterListPresenter(@DomainBus Bus bus,
      ObtainHipstersUserCase obtainHipstersUserCase) {
    return new HipsterListPresenter(bus, obtainHipstersUserCase);
  }

}
