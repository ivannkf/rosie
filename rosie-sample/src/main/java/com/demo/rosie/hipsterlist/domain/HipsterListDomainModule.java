package com.demo.rosie.hipsterlist.domain;

import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCase;
import com.demo.rosie.hipsterlist.domain.usercase.ObtainHipstersUserCaseJob;
import com.path.android.jobqueue.JobManager;
import com.rosie.domain.usercase.UseCaseInvocationHandler;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(library = true,
    complete = false)
public class HipsterListDomainModule {

  @Provides
  public ObtainHipstersUserCase provideHipstersUserCase(JobManager jobManager,
      ObtainHipstersUserCaseJob obtainHipstersUserCaseJob) {
    return (ObtainHipstersUserCase) UseCaseInvocationHandler.getProxy(jobManager, obtainHipstersUserCaseJob);
  }
}
