package com.rosie.domain.usercase;

import android.os.Handler;
import android.os.Looper;

import com.path.android.jobqueue.JobManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ivan on 23/02/15.
 */
public class ResponseInvocationHandler implements java.lang.reflect.InvocationHandler {

    private final JobManager jobManager;
    private final Object response;

    public static Object getProxy(JobManager jobManager, Object response) {
        return java.lang.reflect.Proxy.newProxyInstance(
                response.getClass().getClassLoader(),
                response.getClass().getInterfaces(),
                new ResponseInvocationHandler(jobManager, response));
    }

    private ResponseInvocationHandler(JobManager jobManager, Object response) {
        this.jobManager = jobManager;
        this.response = response;
    }

    public Object invoke(Object proxy, final Method m, final Object[] args) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    m.invoke(response, args);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
        return null;
    }
}