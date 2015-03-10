package com.demo.rosie.hipsterlist.domain.usercase;

import com.demo.rosie.hipsterlist.view.model.HipsterListViewModel;

/**
 *
 */
public interface ObtainHipstersUserCase {
  void obtainHipsters(ObtainHipstersCallback callback);

  public interface ObtainHipstersCallback {
      public void onHipsterObtained(HipsterListViewModel hipsterListViewModel);
  }

}
