package com.rosie.domain.usercase;

import android.util.Log;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 */
public class JobWrapper extends Job {
  protected static final int DEFAULT_PRIORITY = 2;
  private final Object userCase;
  private String nameToExecute = null;

  protected JobWrapper(Object userCase) {
    super(new Params(DEFAULT_PRIORITY));
    this.userCase = userCase;
  }

  protected JobWrapper(Object userCase, String name) {
    this(userCase);
    this.nameToExecute = name;
  }

  @Override public void onAdded() {

  }

  @Override public void onRun() throws Throwable {
    if (userCase != null) {
      Method[] methods = userCase.getClass().getMethods();
      for (Method method : methods) {
        UserCase userCaseMethod = method.getAnnotation(UserCase.class);
        if (userCaseMethod != null) {
          if ((nameIsNullOrEmpty(nameToExecute)) || (userCaseMethod.name()
              .equals(nameToExecute))) {
            try {
              method.invoke(userCase);
            } catch (IllegalAccessException e) {
              Log.e("borrar", "The method must be public", e);
            } catch (InvocationTargetException e) {
              Log.e("borrar", "An error invocation the method", e);
            }
          }
        }
      }
    }
  }

  private boolean nameIsNullOrEmpty(String nameToExecute) {
    return nameToExecute == null || "".equals(nameToExecute);
  }

  @Override protected void onCancel() {

  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}
