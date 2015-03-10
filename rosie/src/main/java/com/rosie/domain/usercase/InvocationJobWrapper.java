package com.rosie.domain.usercase;


import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.lang.reflect.Method;

/**
 * Created by ivan on 10/03/15.
 */
public class InvocationJobWrapper extends Job {

    private static final int DEFAULT_PRIORITY = 2;
    private final Method method;
    private final Object[] args;
    private final Object useCase;

    protected InvocationJobWrapper(Object userCase, Method method, Object[] args) {
        super(new Params(DEFAULT_PRIORITY));
        this.useCase = userCase;
        this.method = method;
        this.args = args;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        method.invoke(useCase, args);
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
