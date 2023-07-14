package com.emandi.user.service;

import com.emandi.user.model.EventStore;

import java.time.LocalDateTime;

public interface EventServiceLog {

    void addEvent(Object event,String eventType);

    Iterable<EventStore> fetchAllEvents(String name);

    Iterable<EventStore> fetchAllEventsTillDate(String name, LocalDateTime date);
}
