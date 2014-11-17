package com.demo.rosie.hipsterlist.domain;

import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCase;
import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCaseJob;
import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(library = true,
    complete = false)
public class HipsterListDomainModule {

  @Provides
  public ObtainHipstersUserCase provideHipstersUserCase(
      ObtainHipstersUserCaseJob obtainHipstersUserCaseJob) {
    return obtainHipstersUserCaseJob;
  }
}
