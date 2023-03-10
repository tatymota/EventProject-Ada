package br.com.ada.evento.dao;
import br.com.ada.evento.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventDAO {
        private static List<Event> events = new ArrayList<>();
        private static int nextID = 1;
        public void add(Event event) {
            event.setId(nextID++);
            events.add(event);
        }

        public void update(Event event) {
            for (int i = 0; i < events.size(); i++) {
                Event p = events.get(i);
                if (p.getId() == event.getId()) {
                    events.set(i, event);
                    break;
                }
            }
        }

        public void delete(int id) {
            events.removeIf(p -> p.getId() == id);
        }

        public Event searchForId(int id) {
            return events.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        }

        public List<Event> searchAll() {
            return events;
        }
}
