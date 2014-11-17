package com.demo.rosie.hipsterlist.domain.usercase;

import com.demo.rosie.hipsterlist.view.model.HipsterListViewModel;
import com.demo.rosie.hipsterlist.view.model.HipsterViewModel;
import com.rosie.domain.usercase.UserCase;
import com.rosie.domain.usercase.UserCaseHandler;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 *
 */
public class ObtainHipstersUserCaseJob implements ObtainHipstersUserCase {

  private final UserCaseHandler userCaseHandler;

  @Inject
  public ObtainHipstersUserCaseJob(UserCaseHandler userCaseHandler) {
    this.userCaseHandler = userCaseHandler;
  }

  @UserCase
  public void executeObtainHipsters() {
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
    userCaseHandler.sendUiMessage(hipsterListViewModel);
  }

  @Override public void obtainHipsters() {
    userCaseHandler.execute(this);
  }
}
