package com.example.wbdvsp2103salehisserverjava.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.example.wbdvsp2103salehisserverjava.models.Widget;
import com.example.wbdvsp2103salehisserverjava.repositories.WidgetRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

  /*
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
                           "initVal",
                           true);
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
                           "initVal",
                           false);
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
                           "initVal",
                           true);

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
  }
  */

  public Widget createWidget(String tid, Widget widget) {
    /*
    Long id = (new Date()).getTime();
    widget.setId(id);
    widgets.add(widget);
    return widget;
    */

    return repository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    /*
    List<Widget> ws = new ArrayList<Widget>();
    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
    */

    return repository.findWidgetsForTopic(tid);
  }

  public int updateWidget(Long wid, Widget widget) {
    /*
    for (int i = 0 ; i < widgets.size() ; i++) {
      Widget w = widgets.get(i);
      if (w.getId().equals(wid)) {
        widgets.set(i, widget);
        return 1;
      }
    }
    return 0;
    */

    Widget originalWidget = findWidgetById(wid);

    originalWidget.setName(widget.getName());
    originalWidget.setId(widget.getId());
    originalWidget.setTopicId(widget.getTopicId());
    originalWidget.setType(widget.getType());
    originalWidget.setWidgetOrder(widget.getWidgetOrder());
    originalWidget.setText(widget.getText());
    originalWidget.setSrc(widget.getSrc());
    originalWidget.setUrl(widget.getUrl());
    originalWidget.setHref(widget.getHref());
    originalWidget.setSize(widget.getSize());
    originalWidget.setWidth(widget.getWidth());
    originalWidget.setHeight(widget.getHeight());
    originalWidget.setCssClass(widget.getCssClass());
    originalWidget.setStyle(widget.getStyle());
    originalWidget.setValue(widget.getValue());
    originalWidget.setOrdered(widget.getOrdered());

    repository.save(originalWidget);
    return 1;
  }

  public int deleteWidget(Long wid) {
    /*
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
    */

    repository.deleteById(wid);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    // return widgets;
    // return (List<Widget>)repository.findAll();

    return repository.findAllWidgets();
  }

  public Widget findWidgetById(Long wid) {
    /*
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        return w;
      }
    }
    return null;
    */
    // return repository.findById(wid).get();

    return repository.findWidgetById(wid);
  }
}