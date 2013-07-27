package pl.mobiid.server.tester.ProxySimulator.threads;

import lombok.Getter;
import pl.mobiid.server.tester.ProxySimulator.threads.ThreadCompleteListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 24.07.13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class ThreadListener implements ThreadCompleteListener {

    private int numberOfCompletedThreads =0;
    List<Thread> threads = new ArrayList<Thread>();

    @Override
    public void notifyOfThreadComplete(Thread thread) {
        //To change body of implemented methods use File | Settings | File Templates.
        numberOfCompletedThreads++;
        System.out.println("CLOSED  " + numberOfCompletedThreads);

    }

    public int getNumberOfCompletedThreads() {
        return numberOfCompletedThreads;
    }

    public void addThread(Thread t ) {
        threads.add(t);
        System.out.println(threads.size());
    }

    public boolean allThreadsComplete() {
        System.out.println(threads.size());
        if(numberOfCompletedThreads == threads.size()) {
            return true;
        }
        else return false;
    }
}
