package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.service.ListItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/list")
public class ListController {


    private ListItemService listItemService;

    public ListController(ListItemService listItemService) {
        this.listItemService = listItemService;
    }

    @PostMapping(value = "/addListItem")
    public ListItem addListItem(@RequestBody ListItem listItem) {
        return listItemService.addListItem(listItem);
    }


}
