package com.example.wbdvsp2103salehisserverjava.controllers;

import com.example.wbdvsp2103salehisserverjava.models.Widget;
import com.example.wbdvsp2103salehisserverjava.services.WidgetService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class WidgetController {
  WidgetService service = new WidgetService();

  @PostMapping
  public Widget createWidget(String tid, Widget widget) {
    return new Widget();
  }

  @GetMapping
  public List<Widget> findWidgetsForTopic(String tid) {
    return new ArrayList<Widget>();
  }

  @PutMapping
  public int updateWidget(String wid, Widget widget) {
    return -1;
  }

  @DeleteMapping
  public int deleteWidget(String wid) {
    return -1;
  }

  @GetMapping
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }
}