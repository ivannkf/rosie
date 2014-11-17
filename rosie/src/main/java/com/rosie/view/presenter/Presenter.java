package com.rosie.view.presenter;

import com.squareup.otto.Bus;

/**
 *
 */
public class Presenter {

  private final Bus domainBus;
  private boolean busRegister;

  public Presenter(Bus domainBus) {
    this.domainBus = domainBus;
  }

  public void enableBus() {
    if (!busRegister) {
      domainBus.register(this);
      busRegister = true;
    }
  }

  public void disableBus() {
    if (busRegister) {
      domainBus.unregister(this);
      busRegister = false;
    }
  }
}
