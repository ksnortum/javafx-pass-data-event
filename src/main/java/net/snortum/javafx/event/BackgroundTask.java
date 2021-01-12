package net.snortum.javafx.event;

import javafx.event.Event;
import javafx.event.EventTarget;

import java.util.stream.IntStream;

public class BackgroundTask {
    void startTask(EventTarget eventTarget) {
        System.out.println("In BackgroundTask...");

        IntStream.range(0, 10).forEach(i -> {
            System.out.println("i = " + i);
            Event event = new ProgressEvent(this, eventTarget, ProgressEvent.PROGRESS, i);
            Event.fireEvent(eventTarget, event);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Done");
    }
}
