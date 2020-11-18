package Momento;

import java.util.ArrayDeque;
import java.util.Deque;

public class History
{
    private Deque<Memento> history = new ArrayDeque<Memento>();

    public void saveToHistory(Memento snapshot)
    {
        if(history.size() == 10)
        {
            history.removeFirst();
        }

        history.addLast(snapshot);
    }

    public Memento getFromHistory()
    {
        return history.pollLast();
    }
}
