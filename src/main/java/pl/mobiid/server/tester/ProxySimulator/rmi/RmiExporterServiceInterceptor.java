package pl.mobiid.server.tester.ProxySimulator.rmi;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.remoting.rmi.RmiInvocationHandler;
import org.springframework.remoting.support.RemoteInvocationBasedAccessor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 13.08.13
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public class RmiExporterServiceInterceptor extends RemoteInvocationBasedAccessor implements MethodInterceptor, Serializable {

    RmiInvocationHandler invocationHandler;

    public RmiExporterServiceInterceptor(RmiInvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        return invocationHandler.invoke(createRemoteInvocation(invocation));
    }
}
