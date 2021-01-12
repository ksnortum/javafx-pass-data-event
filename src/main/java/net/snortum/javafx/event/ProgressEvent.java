package net.snortum.javafx.event;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class ProgressEvent extends Event {
    public static final EventType<ProgressEvent> ANY = new EventType<>(Event.ANY, "PROGRESS");
    public static final EventType<ProgressEvent> PROGRESS =
            new EventType<>(ProgressEvent.ANY, "PROGRESS_INDICATOR");

    private final Object source;
    private final EventTarget target;
    private final EventType<? extends Event> eventType;
    private final int thusFar;

    public ProgressEvent(Object source, EventTarget target, EventType<? extends Event> eventType, int thusFar) {
        super(source, target, eventType);
        this.source = source;
        this.target = target;
        this.eventType = eventType;
        this.thusFar = thusFar;
    }

    @Override
    public Object getSource() {
        return source;
    }

    @Override
    public EventTarget getTarget() {
        return target;
    }

    @Override
    public EventType<? extends Event> getEventType() {
        return eventType;
    }

    public int getThusFar() {
        return thusFar;
    }

}
