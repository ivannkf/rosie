package com.demo.rosie.hipsterlist.view.presenter;

import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCase;
import com.demo.rosie.hipsterlist.view.model.HipsterListViewModel;
import com.demo.rosie.hipsterlist.view.model.HipsterViewModel;
import com.rosie.view.presenter.Presenter;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HipsterListPresenter extends Presenter {

  private View view;
  private final ObtainHipstersUserCase obtainHipstersUserCase;
  ArrayList<HipsterViewModel> hipsters = new ArrayList<HipsterViewModel>();

  public HipsterListPresenter(Bus domainBus, ObtainHipstersUserCase obtainHipstersUserCase) {
    super(domainBus);
    this.obtainHipstersUserCase = obtainHipstersUserCase;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void obtainHipsters() {
    obtainHipstersUserCase.obtainHipsters();
  }

  @Subscribe
  public void hipstersObtained(HipsterListViewModel hipsterListViewModel) {
    hipsters.clear();
    hipsters.addAll(hipsterListViewModel.getHipsters());

    view.updateList();
  }

  public List<HipsterViewModel> getHipsters() {
    return hipsters;
  }

  public interface View {
    public void updateList();
  }
}
