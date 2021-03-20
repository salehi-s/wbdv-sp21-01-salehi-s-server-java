package com.example.wbdvsp2103salehisserverjava.services;

import com.example.wbdvsp2103salehisserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget("Widget1",
                           1L,
                           "topic1",
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
                           "topic2",
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
                           "topic3",
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
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
  }

  public int updateWidget(Long wid, Widget widget) {
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        int wIndex = widgets.indexOf(w);
        widgets.remove(w);
        widgets.add(wIndex, widget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(Long wid) {
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        widgets.remove(w);
        return 1;
      }
    }
    return 0;
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