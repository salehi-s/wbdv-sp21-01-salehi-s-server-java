package com.example.wbdvsp2103salehisserverjava.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.example.wbdvsp2103salehisserverjava.models.Widget;

import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    // Starter Widgets
    Widget w1 = new Widget("Widget1",
                           1L,
                           "6056807cbf36af0017e33f23",
                           "HEADING",
                           1,
                           "Welcome to NEUCourses",
                           "#",
                           "#",
                           "#",
                           1,
                           1,
                           1,
                           "",
                           "",
                           "initVal");
    Widget w2 = new Widget("Widget2",
                           2L,
                           "6056807cbf36af0017e33f23",
                           "PARAGRAPH",
                           2,
                           "Lorem Ipsum",
                           "#",
                           "#",
                           "#",
                           2,
                           2,
                           2,
                           "",
                           "",
                           "initVal");
    Widget w3 = new Widget("Widget3",
                           3L,
                           "6056807cbf36af0017e33f23",
                           "HEADING",
                           3,
                           "CS5610 (Web Development)",
                           "#",
                           "#",
                           "#",
                           3,
                           3,
                           3,
                           "",
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
    for (int i = 0 ; i < widgets.size() ; i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        widgets.set(i, widget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(Long wid) {
    int index = -1;
    for (int i = 0; i < widgets.size(); i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        index = i;
      }
    }
    if (index >= 0) {
      widgets.remove(index);
      return 1;
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