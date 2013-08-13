package pl.mobiid.server.tester.ProxySimulator.rmi;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.remoting.rmi.RmiInvocationHandler;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.Remote;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 13.08.13
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public class ExposeServiceRmiServiceExporter extends RmiServiceExporter {

    private Remote remoteService;

    @Override
    protected Remote getObjectToExport() {
        Remote exportedObject = super.getObjectToExport();

        if (getService() instanceof Remote && (
                getServiceInterface() == null || exportedObject.getClass().isAssignableFrom(getServiceInterface()))) {
            this.remoteService = exportedObject;
        }
        else {
            // RMI Invokers.
            RmiInvocationHandler wrapper = (RmiInvocationHandler) exportedObject;
            ProxyFactory factory = new ProxyFactory(new Class[] { getServiceInterface(), Remote.class });
            factory.addAdvice(new RmiExporterServiceInterceptor(wrapper));

            this.remoteService = (Remote) factory.getProxy();
        }

        return exportedObject;

    }

    public Remote getRemoteService()  {
        return remoteService;
    }
}
