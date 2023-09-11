package jpa.study;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class InitDB {

    @EventListener(ApplicationReadyEvent.class)
    public void initDb(){

    }
}
