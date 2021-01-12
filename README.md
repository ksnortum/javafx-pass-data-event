# javafx-pass-data-event

*javafx-pass-data-event* is a simple demo of one way to pass data using an event.

## How to execute

By far the simplest way to get this project running is to import it into your favorite IDE as a Maven project, build, then run _StartApp_.

## What to notice

Pressing the ```Start``` button launches a background task that counts from 0 to 9, pausing a second in between. As it counts each number, it fires an event.  The main app handles these events, gets the current number, and updates the text field. _BackgroundTask_ can be fairly agnostic as to the GUI node, needing only an _EventTarget_ as the target of the event. 

If you want to see this kind of thing in action, checkout my [Scrabble Words](https://github.com/ksnortum/scrabble-words-java) project.
