package pl.mobiid.server.tester.ProxySimulator.threads;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public abstract class NotifyingThread extends Thread implements Runnable {
    private final Set<ThreadCompleteListener> listeners
            = new CopyOnWriteArraySet<ThreadCompleteListener>();
    public final void addListener(final ThreadCompleteListener listener) {
        listeners.add(listener);
    }
    public final void removeListener(final ThreadCompleteListener listener) {
        listeners.remove(listener);
    }
    private final void notifyListeners() {
        for (ThreadCompleteListener listener : listeners) {
            listener.notifyOfThreadComplete(this);
        }
    }
    @Override
    public final void run() {
        try {
            doRun();
        } finally {
            notifyListeners();
        }
    }
    public abstract void doRun();
}
