package singletonPattern;

import java.util.Queue;
import java.util.LinkedList;

public class QueueApp {
    private static QueueApp instance;
    private Queue<String> queueList;
    private int queueNumberCounter;

    //this prevents instantation outside of the class
    private QueueApp() 
    {
        this.queueList = new LinkedList<>();
        this.queueNumberCounter = 0;
    }

    // get application instance
    public static synchronized QueueApp getInstance() 
    {
        if (instance == null)
            instance = new QueueApp();
        return instance;
    }

    public int getCurrentQueueNumber() 
    {
        queueNumberCounter++;
        return queueNumberCounter;
    }

    public synchronized void addToQueue(String user)
    {
        queueList.add(user);
    }

    public synchronized Queue<String> getQueueList()
    {
        return queueList;
    }
}