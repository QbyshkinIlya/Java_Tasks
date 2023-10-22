package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer implements Subject{
    private Timer timer;

    private List<IObserver> observers = new ArrayList<IObserver>();
    private int state;

    private int timeState;

    public TimeServer() {
        this.timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                tick();

            }
        };
        timer.schedule(task, 1000/*delay*/, 1000/*period*/);
    }

    @Override
    public void notifyAllObserver() {
        for (IObserver obs : observers)
            obs.update();
    }

    private  void tick(){
        timeState++;
        notifyAllObserver();
    }

   /* public int getState() {
        return
    }*/

    public void setState(int time)   {
        this.state = time;
        notifyAllObserver();
    }

    @Override
    public void attach(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void detach(IObserver obs) {
        observers.remove(obs);
    }
}
