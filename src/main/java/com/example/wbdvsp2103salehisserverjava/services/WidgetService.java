package com.example.wbdvsp2103salehisserverjava.services;

import com.example.wbdvsp2103salehisserverjava.models.Widget;
import java.util.List;
import java.util.ArrayList;

public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget("Widget1",
                           1,
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
                           2,
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
                           3,
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
    return new Widget();
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return new ArrayList<Widget>();
  }

  public int updateWidget(String wid, Widget widget) {
    return 0;
  }

  public int deleteWidget(String wid) {
    return 0;
  }

  public List<Widget> findAllWidgets() {
    return new ArrayList<Widget>();
  }

  public Widget findWidgetById(String wid) {
    return new Widget();
  }
}