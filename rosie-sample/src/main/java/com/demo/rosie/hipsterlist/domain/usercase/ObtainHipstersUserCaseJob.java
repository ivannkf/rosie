package com.demo.rosie.hipsterlist.domain.usercase;

import com.demo.rosie.hipsterlist.view.model.HipsterListViewModel;
import com.demo.rosie.hipsterlist.view.model.HipsterViewModel;
import com.rosie.domain.usercase.Response;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 *
 */
public class ObtainHipstersUserCaseJob implements ObtainHipstersUserCase {

  @Inject
  public ObtainHipstersUserCaseJob() {
  }

  public void obtainHipsters(@Response ObtainHipstersCallback callback) {
    //HipsterListViewModel hipsterListViewModel = hipsterParse.parse();
    HipsterListViewModel hipsterListViewModel = new HipsterListViewModel();
    HipsterViewModel hipsterTest = new HipsterViewModel();
    hipsterTest.setName("Hipstotito Fernandez");
    hipsterTest.setAvatarUrl(
        "https://cdn0.iconfinder.com/data/icons/avatars-3/512/avatar_hipster_guy-512.png");
    hipsterTest.setId("1");

    ArrayList<HipsterViewModel> hipsterViewModels = new ArrayList<HipsterViewModel>();
    hipsterViewModels.add(hipsterTest);
    hipsterListViewModel.setHipsters(hipsterViewModels);
    callback.onHipsterObtained(hipsterListViewModel);
  }

}
