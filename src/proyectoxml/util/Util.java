package proyectoxml.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Util {
    public static void setTimeout(Runnable runnable, int delay) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(new Runnable() {
            public void run() {
                runnable.run();
            }
        }, delay, TimeUnit.MILLISECONDS);
    }
}
