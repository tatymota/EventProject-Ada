package br.com.ada.evento.controller;
import br.com.ada.evento.dao.EventDAO;
import br.com.ada.evento.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

        @Autowired
        private EventDAO eventDAO;

        @GetMapping
        public String list(Model model) {
            List<Event> eventList = eventDAO.searchAll();
            model.addAttribute("events", eventList);
            return "event_list";
        }

        @GetMapping("/edit/{id}")
        public String edit(@PathVariable int id, Model model) {
            Event event = eventDAO.searchForId(id);
            model.addAttribute("event", event);
            return "event_edit";
        }

        @PostMapping("/edit")
        public String update(Event event) {
            eventDAO.update(event);
            return "redirect:/event";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable int id) {
            eventDAO.delete(id);
            return "redirect:/event";
        }
        @GetMapping("/new")
        public String newEvent(Event event, Model model) {
            model.addAttribute("event", event);
            return "event_new";
        }

        @PostMapping("/new")
        public String addNew(Event event) {
            eventDAO.add(event);
            return "redirect:/event";
        }
}

