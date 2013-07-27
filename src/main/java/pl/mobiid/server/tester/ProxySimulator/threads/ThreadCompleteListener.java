package pl.mobiid.server.tester.ProxySimulator.threads;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public interface ThreadCompleteListener {
    void notifyOfThreadComplete(final Thread thread);
    int getNumberOfCompletedThreads();
    public boolean allThreadsComplete();
    public void addThread(Thread t );
}
