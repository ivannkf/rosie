package com.rosie.domain.usercase;

import com.path.android.jobqueue.JobManager;

import java.lang.reflect.Method;

/**
 * Created by ivan on 23/02/15.
 */
public class UseCaseInvocationHandler implements java.lang.reflect.InvocationHandler {

    private final JobManager jobManager;
    private final Object useCase;

    public static Object getProxy(JobManager jobManager, Object useCase) {
        return java.lang.reflect.Proxy.newProxyInstance(
                useCase.getClass().getClassLoader(),
                useCase.getClass().getInterfaces(),
                new UseCaseInvocationHandler(jobManager, useCase));
    }

    private UseCaseInvocationHandler(JobManager jobManager, Object useCase) {
        this.jobManager = jobManager;
        this.useCase = useCase;
    }

    public Object invoke(Object proxy, final Method m, final Object[] args) {
        InvocationJobWrapper jobWrapper = new InvocationJobWrapper(useCase, m, args);
        jobManager.addJob(jobWrapper);
        jobManager.start();
        return null;
    }
}