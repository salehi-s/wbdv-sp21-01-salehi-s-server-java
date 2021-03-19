package com.example.wbdvsp2103salehisserverjava.services;

import com.example.wbdvsp2103salehisserverjava.models.Widget;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget("Widget1",
                           1L,
                           "HEADING",
                           1,
                           "Welcome",
                           "#",
                           "#",
                           "#",
                           9,
                           3,
                           3,
                           "cssClass",
                           "",
                           "initVal");
    Widget w2 = new Widget("Widget2",
                           2L,
                           "LIST",
                           2,
                           "WidgetList",
                           "#",
                           "#",
                           "#",
                           16,
                           4,
                           4,
                           "cssClass",
                           "",
                           "initVal");
    Widget w3 = new Widget("Widget3",
                           3L,
                           "PARAGRAPH",
                           3,
                           "P1",
                           "#",
                           "#",
                           "#",
                           25,
                           5,
                           5,
                           "cssClass",
                           "",
                           "initVal");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
  }

  public Widget createWidget(String tid, Widget widget) {
    Long id = (new Date()).getTime();
    widget.setId(id);
    widgets.add(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return new ArrayList<Widget>();
  }

  public int updateWidget(Long wid, Widget widget) {
    return -1;
  }

  public int deleteWidget(Long wid) {
    return -1;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(Long wid) {
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        return w;
      }
    }
    return null;
  }
}