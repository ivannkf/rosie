package com.rosie.domain.usercase;

import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Bus;

/**
 *
 */
public class UserCaseHandler {
  private final Bus bus;
  JobManager jobManager;

  public UserCaseHandler(JobManager jobManager, Bus bus) {
    this.jobManager = jobManager;
    this.bus = bus;
  }

  public void execute(Object task) {
    JobWrapper jobWrapper = new JobWrapper(task);
    jobManager.addJob(jobWrapper);
    jobManager.start();
  }

  public void execute(Object task, String name) {
    JobWrapper jobWrapper = new JobWrapper(task, name);
    jobManager.addJob(jobWrapper);
    jobManager.start();
  }

  public void sendUiMessage(Object objectToUI) {
    bus.post(objectToUI);
  }
}
