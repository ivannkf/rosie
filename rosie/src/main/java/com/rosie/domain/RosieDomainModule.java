package com.rosie.domain;

import android.content.Context;
import com.path.android.jobqueue.JobManager;
import com.rosie.daggerutils.DomainBus;
import com.rosie.daggerutils.ForApplication;
import com.rosie.domain.usercase.AndroidBus;
import com.rosie.domain.usercase.UserCaseHandler;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * This module provide global dependencies for all domain objects.
 */
@Module(complete = false,
    library = true)
public class RosieDomainModule {
  @Provides @Singleton JobManager provideJobManager(@ForApplication Context context) {
    return new JobManager(context);
  }

  @Provides @Singleton @DomainBus Bus provideDomainBus() {
    return new AndroidBus();
  }

  @Provides UserCaseHandler provideUserCaseHandler(JobManager jobManager,
      @DomainBus Bus bus) {
    return new UserCaseHandler(jobManager, bus);
  }
}

